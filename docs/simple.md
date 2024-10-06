# 이곳에 정리

```
package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // [1번 문제: Repository 어노테이션 추가]
public class HelloDao {
private JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // [2번 문제: INSERT 쿼리 작성]
    public void insert(String name) {
        String SQL = "INSERT INTO hello(name) VALUES(?)";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    // [2번 문제: COUNT 쿼리 작성]
    public int countByName(String name) {
        String sql = "SELECT COUNT(*) FROM hello WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}
```

> 1번 문제
- @Repository:
  -  목적: Spring에게 이 클래스가 데이터 접근 계층임을 알리고, 자동으로 빈(Bean)으로 등록되도록 합니다.
  -  컴포넌트 스캔 지원: Spring의 컴포넌트 스캔 기능을 통해 자동으로 빈으로 등록됩니다.
  -  장점:
    -  유지보수성 향상: 데이터 접근 로직이 명확히 분리되어 관리하기 용이합니다.
    -  테스트 용이성: Spring의 의존성 주입(DI)과 결합하여 테스트가 용이해집니다.
> 2번 문제
- String SQL = "INSERT INTO hello(name) VALUES(?)";
  -  목적: 클라이언트로부터 받은 name을 데이터베이스의 hello 테이블에 삽입합니다.
  -  "INSERT INTO hello(name) VALUES(?)"을 사용하여 name 값을 안전하게 삽입합니다.
  -  jdbcTemplate.update(SQL, new Object[]{name})을 통해 SQL 인젝션 공격을 방지하고, 값의 안전한 전달을 보장합니다.
> 3번 문제
- String sql = "SELECT COUNT(*) FROM hello WHERE name = ?";
  - 목적: 특정 name의 방문 횟수를 데이터베이스에서 조회합니다.
  - "SELECT COUNT(*) FROM hello WHERE name = ?"을 사용하여 해당 이름의 방문 횟수를 계산합니다.
  - jdbcTemplate.queryForObject(sql, Integer.class, name)을 통해 결과를 정수형으로 반환합니다. 

