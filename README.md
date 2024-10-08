# Part1. :leaves: 테스트로 배우는 Spring MVC 학습 테스트 :leaves:

테스트 코드들을 성공시키면서 스프링의 사용법, 동작 원리에 대해 알아봅시다!

## :rocket: 미션 진행 방법

- build.gradle을 참고하여 환경 설정은 스스로 찾아서 한다.
- 미션을 시작할 때, `해당 기수(앞년도만) + 자신의 영문 이름`으로 브랜치를 파고(예: `24YoonByungWook`), 해당 레포에 브랜치를 생성한다.
- `main` 브랜치는 절대 건들지 말아주세요!!
- 이후 `fork`하여 개인 브랜치에서 작업한다.(fork할때, 모든 브랜치를 fork한다!) 미션을 마치면 해당 레포로 병합 요청한다.
- 리뷰 후 병합할 예정입니다!

<br/>

- 예시
```text
git status
- On branch main
git branch 24YoonByungWook
git checkout 24YoonByungWook
git push origin 24YoonByungWook
// 이후 fork하여 개인 레포에서 미션 진행
```

<br/>

## 0. 초간단 스프링 프로젝트

- [초간단 스프링 프로젝트 브랜치](https://github.com/gdsc-konkuk/24-25-study-spring-learning-with-test/tree/simple)

- 첫번째 미션은 `simple` 브랜치에서 진행합니다. 

<br/>

## 1. Spring CORE

- [Spring CORE 브랜치](https://github.com/gdsc-konkuk/24-25-study-spring-learning-with-test/tree/core)

- 두번째 미션은 `core` 브랜치에서 진행합니다!

<br/>

## 2. Spring MVC

- [Spring MVC 브랜치](https://github.com/gdsc-konkuk/24-25-study-spring-learning-with-test/tree/mvc)
- 다음은 `mvc` 브랜치에서 진행합니다!

<br/>

## 3. Spring MVC Config 

- [Spring MVC Config 브랜치](https://github.com/gdsc-konkuk/24-25-study-spring-learning-with-test/tree/mvc-config)
- 다음은 `mvc-config` 브랜치에서 진행합니다!

## 이어서
모든 과정을 완수하셨다면 다음 단계로 넘어갈 차례입니다! 여기서부터는 더 어려워지니 스프링 찍먹만 해보고 싶으셨던 분들은 여기까지 하시면 될 것 같습니다!

다음 레포는 간단한 spring MVC를 실제로 구현해보는 미션입니다. [Part2. MVC 구현하기](https://github.com/gdsc-konkuk/24-25-study-java-mvc)
=======
# 📖 Spring Core 학습 테스트
- Spring Core 기능을 학습하기 위한 테스트 프로젝트

## :hand: 공지 :hand:

앞으로 있을 모든 미션에서 지식은 여러분들이 직접 공부하면서 정리하셔야 합니다.

이 미션에서 필요한 레퍼런스는 이미 나눠 드렸습니다!
지식이라는 건 자신이 자신만의 방법(언어)으로 정리하고 습득하는 것이 가장 효율적입니다. 저는 여러분들께 공부할 수 있는 자료를 나눠 드렸고, 정리 하시는 건 각자 몫입니다.


앞으로 각자 공부하는 내용들을 정리해서 `docs/spring-core`에 문서화 해주시면 됩니다.! (만약 블로그를 운영중, 혹은 블로그 포스팅 스터디를 하신다면 이왕 하는거 같이 하면 굿)

질문은 언제나 환영입니다! 대신 디스코드의 질의응답, 채널에 부탁드립니다! 그리고 스터디장(저)도 공부하고 있는 입장이라 부족할 수 있습니다. 아는 선에서 최대한 답변 드리겠습니다!

<br/>

## 📋 테스트 목록
- scan: component scan을 통해 스프링 빈 등록 학습 테스트
- di: 스프링 빈들의 의존성 주입 학습 테스트

<br/>

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

<br/>

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
