package nextstep.helloworld.controller;

import nextstep.helloworld.dao.HelloDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private HelloDao helloDao;

    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "") String name) {
        return "Hello " + name;
    }

}
