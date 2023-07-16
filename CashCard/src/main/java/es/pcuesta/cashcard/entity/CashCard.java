package es.pcuesta.cashcard.entity;

import jakarta.persistence.Id;

public record CashCard(@Id Long id, Double amount) {
}
