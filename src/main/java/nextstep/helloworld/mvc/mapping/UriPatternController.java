package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping("/users/{id:\\d+}")
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email");
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/patterns/{chr:[a-z]}")
    public ResponseEntity<String> pattern(@PathVariable(name = "chr") String ignored) {
        return ResponseEntity.ok().body("pattern");
    }

    @GetMapping("/patterns/{*pattern}")
    public ResponseEntity<String> patternStars(@PathVariable(name = "pattern") String ignored) {
        return ResponseEntity.ok().body("pattern-multi");
    }
}
