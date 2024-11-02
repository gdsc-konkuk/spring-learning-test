package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping(path = "/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(path = "/message", params = "name")
    public ResponseEntity<String> messageForParam(@RequestParam String name) {
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping(path = "message", headers = "HEADER")
    public ResponseEntity<String> messageForHeader(@RequestHeader("HEADER") String header) {
        return ResponseEntity.ok().body("hi");
    }
}