package nextstep.helloworld.mvc.mapping;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uri-pattern")
public class UriPatternController {

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> pathVariable(@PathVariable Long id) {
        User user = new User(id, "이름", "email@example.com");
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("patterns/{value}")
    public ResponseEntity<String> pattern(@PathVariable String value) {
        return ResponseEntity.ok().body("pattern");
    }
    @GetMapping("patterns/**")//대체이부분 어떻게 해결..?
    public ResponseEntity<String> patternStars() {
        return ResponseEntity.ok().body("pattern-multi");
    }
}