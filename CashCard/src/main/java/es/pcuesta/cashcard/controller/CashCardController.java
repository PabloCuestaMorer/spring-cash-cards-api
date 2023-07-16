package es.pcuesta.cashcard.controller;

import es.pcuesta.cashcard.entity.CashCard;
import es.pcuesta.cashcard.repository.CashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private final CashCardRepository cashCardRepository;

    @Autowired
    public CashCardController(final CashCardRepository repository) {
        this.cashCardRepository = repository;
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
        return cashCardOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
