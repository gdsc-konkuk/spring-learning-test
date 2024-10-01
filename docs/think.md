# 생각해 볼까요?

> 다음은 알아두면 재밌을, 어쩌면 몰라도 크게 상관없을 내용들이기도 합니다.
> 
> 관심이 있는 주제(최소 1개)에 대해서 더 알아보고 스터디원과 생각을 교류해 봅시다!

1. **Web**은 무엇일까요? Web의 역사에 대해 아시나요?
    - Server Client Pattern은 무엇일까요?
    - [WWW의 창시자](https://ko.wikipedia.org/wiki/%ED%8C%80_%EB%B2%84%EB%84%88%EC%8A%A4%EB%A6%AC)가 [WWW를 비난](https://www.inrupt.com/)한 사실을 알고 계신가요?
2. **Layered Architecture**는 왜 사용할까요?
    - Layered Architecture의 **단점**은 무엇일까요?
3. **RESTful API**란 무엇일까요?
    - `safe`, `idempotent`, `cacheable`에 대해 아시나요?
        - `idempotent`는 왜 중요할까요? **PRG Pattern**에 대해 아시나요?
    -  대체제는 어떤게 있을까요? `GraphQL`, `gRPC`, `SOAP`에 대해 들어보셨나요?
4. **WAS와 Web Server의 차이**를 알고 계신가요?
    - 현대의 WAS는 Web Serving 능력이 출중하다고 합니다. 그런데도 왜 아직 둘을 나누는게 더 일반적일까요?
5. **Server Framework**은 어떤 것들이 있나요? Spring Framework가 다른 Framework에 비해 가지는 **장단점**은 무엇인가요?
    - Framework란 무엇인가요? Library랑 다른게 무엇일까요?
    - `php`를 아시나요? `Nest.js`와 `Django`는 어떤가요?
    - Java를 사용하는 Server Framework가 Spring이라고요? 그럼 혹시 `Dropwizard`에 대해서는 알고 계신가요?

# 아래에 정리해 주세요!

> 정리 양식은 자유입니다! 몇 가지 주제에 대해서 알아오셨나요?
### **Layered Architecture**는 왜 사용할까요? **단점**은 무엇일까요?
- Layered Architecture : UI Layer, Business Layer, Data Acesss Layer로 논리적인 계층을 분리시켜 개발하는 것.
- 유지보수성, 모듈성, 테스트용이성을 위해 사용한다.
- 복잡성, 성능 저하, 과도한 추상화가 단점으로 작용한다.

### **RESTful API**란 무엇일까요?
- Stateless, Uniform Interface, Resource Representation의 스타일을 지키는 API

### `safe`, `idempotent`, `cacheable`에 대해 아시나요? idempotent`는 왜 중요할까요? 
- safe: HTTP 메서드 중 GET과 같이 서버의 상태를 변경하지 않는 요청을 "safe"하다고 합니다. 이는 클라이언트가 동일한 요청을 여러 번 보내도 서버의 상태는 변하지 않는다는 의미입니다.
- idempotent: PUT이나 DELETE 메서드는 여러 번 호출해도 같은 결과를 반환해야 하는 특성을 가집니다. 즉, 같은 요청을 여러 번 반복해도 서버의 상태는 동일하게 유지됩니다. 
- cacheable: GET 요청의 경우 클라이언트나 중간 서버에서 결과를 캐시할 수 있으며, 이를 통해 성능 최적화가 가능합니다.

### PRG Pattern (Post/Redirect/Get 패턴)이란?
PRG (Post/Redirect/Get) 패턴은 웹 애플리케이션에서 POST 요청 후 페이지 새로 고침으로 인해 발생할 수 있는 중복 요청 문제를 해결하기 위해 사용됩니다.

### **WAS와 Web Server의 차이**를 알고 계신가요? 현대의 WAS는 Web Serving 능력이 출중하다고 합니다. 그런데도 왜 아직 둘을 나누는게 더 일반적일까요?
- Web Server: 정적 컨텐츠(HTML, CSS, 이미지 등)를 제공하고, 클라이언트의 HTTP 요청을 처리합니다. 주로 Nginx, Apache 같은 서버가 해당됩니다.
- WAS (Web Application Server): 동적인 웹 애플리케이션을 처리하는 서버로, 비즈니스 로직과 데이터베이스 연동을 처리합니다. Java 기반의 WAS로는 Tomcat, JBoss 등이 있습니다.
