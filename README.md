# 📖 Spring Core 학습 테스트
- Spring Core 기능을 학습하기 위한 테스트 프로젝트

## :sunny: 공지 :sunny:

앞으로 있을 모든 미션에서 지식은 여러분들이 직접 공부하면서 정리하셔야 합니다.

이 미션에서 필요한 레퍼런스는 이미 나눠 드렸습니다!
지식이라는 건 자신이 자신만의 방법(언어)으로 정리하고 습득하는 것이 가장 효율적입니다. 저는 여러분들께 공부할 수 있는 자료를 나눠 드렸고, 정리 하시는 건 각자 몫입니다.


앞으로 각자 공부하는 내용들을 정리해서 `docs/spring-core`에 문서화 해주시면 됩니다.! (만약 블로그를 운영중, 혹은 블로그 포스팅 스터디를 하신다면 이왕 하는거 같이 하면 굿)

질문은 언제나 환영입니다! 대신 디스코드의 질의응답, 채널에 부탁드립니다! 그리고 스터디장(저)도 공부하고 있는 입장이라 부족할 수 있습니다. 아는 선에서 최대한 답변 드리겠습니다!

## 테스트 목록
- scan: component scan을 통해 스프링 빈 등록 학습 테스트
- di: 스프링 빈들의 의존성 주입 학습 테스트

## 학습 테스트 활용 방법

---
### 1. 테스트 확인하기

- 테스트 메서드의 주석을 확인하여 프로덕션 코드에 추가할 내용을 인지하기

```java
/**
 * TODO: core > scan 패키지 내에 있는 클래스를 스프링 빈으로 등록하기
 */
@Test
void componentScan() {
    ApplicationContext context = getApplicationContext();
    LineDao dao = context.getBean("lineDao", LineDao.class);
    assertThat(dao).isNotNull();

    LineService service = context.getBean("lineService", LineService.class);
    assertThat(service).isNotNull();
}
```  


---

### 2. 프로덕션 코드에 기능 구현하기

```java
package nextstep.helloworld.core.scan;

import org.springframework.stereotype.Service;

@Service
public class LineService {
}
```

---

### 3. 테스트 다시 수행

- 기능이 정상적으로 동작하는지 검증
<p align="center">
  <img src="https://techcourse-storage.s3.ap-northeast-2.amazonaws.com/83828cfd9aa649eab2b1f5933a8c39d8" width="70%">
</p>

---

## 참고 레퍼런스 모음

### scan
- [@Component](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-stereotype-annotations)

### di
- [Dependencies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-dependencies)
- [Constructor Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-constructor-injection)
- [Setter Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-setter-injection)
- [Field Injection](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-autowired-annotation)

<br/>

- 토비의 스프링
- 구글링(웬만하면 공식 문서를 추천)
