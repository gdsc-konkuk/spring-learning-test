과거에 공부한 내용 첨부합니다.

**스프링 프레임워크** - 스프링의 핵심 기술을 포함하는 프레임워크
**스프링 부트** - 스프링의 설정을 편하게 해주는 프레임워크
스프링은 자바 언어기반의 프레임워크 + 자바 언어의 가장 큰 특징 “객체지향” → 객체 지향 언어가 가진 특징을 살려내는 프레임워크
**객체지향 프로그래밍의 장점**
- 역할과 구현으로 구분하면 단순해지고 유연해지며 변경이 편리하다.
    - 클라이언트는 인터페이스만 알면된다.
    - 클라이언트는 내부구조를 몰라도 되고 변경되어도 영향을 받지않는다.
      **스프링과 객체 지향**
- 다형성이 가장 중요하다. 스프링은 이걸 극대화 시킴.
- 제어의 역전 (IoC), 의존관계 주입(DI) 등을 제공함.
 
### **JDBC Template**

```java
@Configuration
public class SpringConfig {
  private final DataSource dataSource;
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
	}
	...
}
```

DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다.

스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다.

그래서 DI를 받을 수 있다. (아래처럼 레포지토리 클래스에 생성자로 해주면됨)

```java
private final JdbcTemplate jdbcTemplate;

public JdbcTemplateMemberRepository(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
}

```

쿼리는 이렇게 보낼 수 있다.

```java
@Override
public Optional<Member> findById(Long id) {
    List<Member> result = jdbcTemplate
					.query("select * from member where id= ?", memberRowMapper(), id);
    return result.stream().findAny();
}
```

RowMapper 선언 및 객체 생성. RowMapper의 경우에는 데이터베이스에서 조회한 결과를 Java 객체로 변환하는 과정을 단순화 시킬 수 있다.

```java
private RowMapper<Member> memberRowMapper() {
   return (rs, rowNum) -> {
       Member member = new Member();
       member.setId(rs.getLong("id"));
       member.setName(rs.getString("name"));
       return member;
};}
```
