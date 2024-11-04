package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping(value = "/message")
    public ResponseEntity<String> string() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/users")
    public ResponseEntity<User> responseBodyForUser() {
        return ResponseEntity.ok().body(new User("name", "email"));
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> responseEntity(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping(value = "/members")
    public ResponseEntity<Void> responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/thymeleaf", produces = "text/html")
    public ResponseEntity<String> thymeleaf() {
        return ResponseEntity.ok().body("Hello");
    }
}