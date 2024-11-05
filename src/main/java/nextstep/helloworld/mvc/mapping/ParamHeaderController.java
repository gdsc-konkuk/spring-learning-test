package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {
    @GetMapping("/message")
    public ResponseEntity<String> messageForParam(
            @RequestParam(required = false) String name,
            @RequestHeader(value = "HEADER", required = false) String header) {

        // HEADER 헤더가 "hi"인 경우 다른 응답
        if ("hi".equals(header)) {
            return ResponseEntity.ok().body("hi");
        }

        // HEADER 헤더가 없을 경우 또는 "hi"가 아닐 경우 기본 응답
        if (name != null) {
            return ResponseEntity.ok().body("hello");
        } else {
            return ResponseEntity.ok().body("message");
        }
}}