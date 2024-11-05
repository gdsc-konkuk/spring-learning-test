package nextstep.helloworld.mvc.exceptions;

import nextstep.helloworld.mvc.exceptions.exception.CustomException;
import nextstep.helloworld.mvc.exceptions.exception.HelloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exceptions")
public class ExceptionsController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity exceptionHandler() {
        return ResponseEntity.badRequest().body("CustomException");
    }

    @GetMapping("/hi")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity exceptionHandler2() {
        return ResponseEntity.badRequest().body("HelloException");
    }

    public ResponseEntity<String> handle() {
        return ResponseEntity.badRequest().body("CustomException");
    }
}