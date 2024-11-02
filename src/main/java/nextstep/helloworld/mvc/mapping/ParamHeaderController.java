package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping("/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/message", params = {"name"})
    public ResponseEntity<String> messageForParam(@RequestParam String name) {
        return ResponseEntity.ok().body(name);
    }

    @GetMapping(value = "/message", headers = {"HEADER"})
    public ResponseEntity<String> messageForHeader(@RequestHeader String HEADER) {
        return ResponseEntity.ok().body(HEADER);
    }
}
