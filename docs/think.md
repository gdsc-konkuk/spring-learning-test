# 생각해 볼까요?

> 다음은 알아두면 재밌을, 어쩌면 몰라도 크게 상관없을 내용들이기도 합니다.
>
> 관심이 있는 주제(최소 1개)에 대해서 더 알아보고 스터디원과 생각을 교류해 봅시다!

1. **Web**은 무엇일까요? Web의 역사에 대해 아시나요?
    - Server Client Pattern은 무엇일까요?
    - [WWW의 창시자](https://ko.wikipedia.org/wiki/%ED%8C%80_%EB%B2%84%EB%84%88%EC%8A%A4%EB%A6%AC)
      가 [WWW를 비난](https://www.inrupt.com/)한 사실을 알고 계신가요?
2. **Layered Architecture**는 왜 사용할까요?
    - Layered Architecture의 **단점**은 무엇일까요?
3. **RESTful API**란 무엇일까요?
    - `safe`, `idempotent`, `cacheable`에 대해 아시나요?
        - `idempotent`는 왜 중요할까요? **PRG Pattern**에 대해 아시나요?
    - 대체제는 어떤게 있을까요? `GraphQL`, `gRPC`, `SOAP`에 대해 들어보셨나요?
4. **WAS와 Web Server의 차이**를 알고 계신가요?
    - 현대의 WAS는 Web Serving 능력이 출중하다고 합니다. 그런데도 왜 아직 둘을 나누는게 더 일반적일까요?
5. **Server Framework**은 어떤 것들이 있나요? Spring Framework가 다른 Framework에 비해 가지는 **장단점**은 무엇인가요?
    - Framework란 무엇인가요? Library랑 다른게 무엇일까요?
    - `php`를 아시나요? `Nest.js`와 `Django`는 어떤가요?
    - Java를 사용하는 Server Framework가 Spring이라고요? 그럼 혹시 `Dropwizard`에 대해서는 알고 계신가요?

# 아래에 정리해 주세요!

> 정리 양식은 자유입니다! 몇 가지 주제에 대해서 알아오셨나요?

### **Server Framework**에 대해서...

Spring은 굉장히 대규모 프로젝트입니다. Spring Data, Spring Boot, Spring AI... 정말 많은 프로젝트가 있습니다.
위에 예시로 나온 것 처럼 `Dropwizard`처럼 jvm 진영에 다른 Server Framework가 존재함에도 불구하고,
대부분의 사람이 jvm Server를 얘기하면 Spring을 떠올리곤 합니다.

Laravel은 자세힌 모르지만 php란 점에서 주변 사람들이 별로 내켜하지 않는 인상을 받았습니다.
하지만 해외에선 여전히 강하다고...?

RoR(Ruby on Rails)은 빠른 개발에 강점을 보여 여러 기업에서 채택했다고 알고 있습니다. 보통 서비스 시작을
RoR로 하고, 이후 점차 Spring과 같은 조금 더 대규모에 적합한 Framework로 migration을 진행한다고 합니다.

Nest.js는 Node.js 진영에서 떠오르는 Server Framework입니다. 다만, 엄격한 구조의 Server를 디자인한다면
Spring을 사용하는게 더 낫지 않느냐, 소위 "그럴 바엔 Spring 쓴다"란 평을 많이 들었습니다.

Go와 Rust는 떠오르는 신흥 강자이지만, 아직까지 Major한 선택지는 아닌 것으로 보입니다.
(두 언어에서 대중적인 Server Framework이 무엇인지는 잘 모르겠네요)

Haskell 혹은 Elixir를 발견하셨다면 도망가시길 권해드립니다. 뉴비가 함부러 건드려선 안 된다고 들었습니다.
어쩌면 여러분과 같은 천재들은 오히려 잘 맞을지도?
