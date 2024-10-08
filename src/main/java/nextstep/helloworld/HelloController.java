package nextstep.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private final HelloDao helloDao;

  public HelloController(HelloDao helloDao) {
    this.helloDao = helloDao;
  }

  @GetMapping("/hello")
  public String hello() {
    return "HelloWorld!";
  }

  @GetMapping(value = "/hello", params = "name")
  public String hello(@RequestParam String name) {
    helloDao.insert(name);
    int count = helloDao.countByName(name);
    return "Hello " + name + " " + count + "번째 방문입니다.";
  }
}
