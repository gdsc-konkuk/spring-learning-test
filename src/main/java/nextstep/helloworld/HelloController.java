package nextstep.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private HelloDao helloDao;

    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @GetMapping("/reset")
    public String resetDao() {
        // 실수로 HelloDao 객체를 다시 생성하고 할당하는 코드
        // 의도치 않게 HelloDao 필드가 변경됨
        this.helloDao = new HelloDao(null); // 잘못된 할당
        return "DAO has been reset!";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "") String name) {
        if (name.isEmpty()) {
            return "HelloWorld!";
        }

        helloDao.insert(name);
        int count = helloDao.countByName(name);
        return "Hello " + name + " " + count + "번째 방문입니다.";
    }
}