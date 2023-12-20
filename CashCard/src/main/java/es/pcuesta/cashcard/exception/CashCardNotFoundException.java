package es.pcuesta.cashcard.exception;

public class CashCardNotFoundException extends RuntimeException {

    public CashCardNotFoundException(String message) {
        super(message);
    }
}
