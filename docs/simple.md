# 이곳에 정리

Sample Code는 다음과 같습니다.

```java

@GetMapping("/hello")
public String hello(@RequestParam(defaultValue = "") String name) {
  if (name.isEmpty()) {
    return "HelloWorld!";
  }

  helloDao.insert(name);
  int count = helloDao.countByName(name);
  return "Hello " + name + " " + count + "번째 방문입니다.";
}
```

그런데 DB Scheme은 다음과 같습니다.

```sql
CREATE TABLE hello
(
    id   bigint AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    primary key (id)
);
```

즉, `name`으로 empty string이 가능합니다. 만약 `GET /hello?name`으로 요청할 경우는 어떻게 될까요?
그래서 전 다음과 같이 코드를 수정했습니다.

```java

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
```
