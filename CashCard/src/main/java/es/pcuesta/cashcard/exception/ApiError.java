package es.pcuesta.cashcard.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;

}
