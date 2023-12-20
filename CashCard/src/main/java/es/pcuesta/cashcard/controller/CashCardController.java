package es.pcuesta.cashcard.controller;

import es.pcuesta.cashcard.entity.CashCard;
import es.pcuesta.cashcard.exception.CashCardNotFoundException;
import es.pcuesta.cashcard.repository.CashCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private final CashCardRepository cashCardRepository;
    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CashCard newCashCardRequest, UriComponentsBuilder ucb) {
        CashCard savedCashCard = cashCardRepository.save(newCashCardRequest);
        // UriComponentsBuilder ucb --> Injected from Spring's IoC Container. Thanks, Spring Web!
        URI locationOfTheNewCashCard = ucb.path("cashcards/{id}").buildAndExpand(savedCashCard.getId()).toUri();
        return ResponseEntity.created(locationOfTheNewCashCard).build();
    }


    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        return cashCardOptional.map(ResponseEntity::ok).
                orElseThrow(() -> new CashCardNotFoundException("Cash Card not found with id: " + requestedId));
    }

    @GetMapping
    public ResponseEntity<List<CashCard>> findAll(Pageable pageable) {
        Page<CashCard> page = cashCardRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC, "amount"))
                ));
        return ResponseEntity.ok(page.getContent());
    }

    @PutMapping("/{requestedId}")
    public ResponseEntity<Void> update(@PathVariable Long requestedId, @RequestBody CashCard cashCardUpdate) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);

        if (cashCardOptional.isPresent()) {
            CashCard updatedCashCard = new CashCard(cashCardOptional.get().getId(), cashCardUpdate.getAmount());
            cashCardRepository.save(updatedCashCard);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (cashCardRepository.existsById(id)) {
            cashCardRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
