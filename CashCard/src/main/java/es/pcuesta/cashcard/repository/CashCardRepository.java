package es.pcuesta.cashcard.repository;

import es.pcuesta.cashcard.entity.CashCard;
import org.springframework.data.repository.CrudRepository;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
