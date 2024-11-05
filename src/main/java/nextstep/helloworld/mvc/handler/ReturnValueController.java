package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping("/message")
    public ResponseEntity<String> string() {
        return ResponseEntity.ok().body("message");
    }
    @GetMapping("/users")
    public ResponseEntity<User> responseBodyForUser() {
        User user = new User("name","email");
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> responseEntity(@PathVariable Long id) {
        User user = new User(id,"name","email");
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/members")
    public ResponseEntity<Object> responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("thymeleaf")
    public ResponseEntity<String> thymeleaf() {
        return ResponseEntity.ok().body("Hello");
    }
}