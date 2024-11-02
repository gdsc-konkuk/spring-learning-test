package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping(path = "/message", produces = "application/json")
    @ResponseBody
    public String string(){
        return "message";
    }

    @GetMapping(path = "/users", produces = "application/json")
    @ResponseBody
    public User responseBodyForUser(){
        return new User("name", "email");
    }

    @GetMapping(path = "/users/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<User> responseEntity(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new User("name", "email"));
    }

    @GetMapping(path = "/members", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Object> responseEntityFor400(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @GetMapping(path = "/thymeleaf", produces = "text/html")
    public String thymeleaf(Model model){
        model.addAttribute("name", "jihong");
        return "sample";
    }



}