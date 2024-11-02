package nextstep.helloworld.mvc.exceptions;

import nextstep.helloworld.mvc.exceptions.exception.HelloException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HelloAdvice {
    @ExceptionHandler
    public ResponseEntity<String> handle(HelloException ignored) {
        return ResponseEntity.badRequest().body("HelloException");
    }
}
