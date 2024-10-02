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
### WAS와 Web Server의 차이를 알고 계신가요?
네, Web Server는 정적인 콘텐츠(HTML, 이미지 등)를 클라이언트에게 전달하는 역할을 주로 수행합니다.  
반면에 WAS(Web Application Server)는 동적인 웹 애플리케이션을 실행하고 비즈니스 로직을 처리하는 서버입니다.  
즉, WAS는 Web Server의 기능에 더해 데이터베이스 연동, 세션 관리 등 복잡한 작업을 수행합니다.
- 웹 서버
  - 정의 : 정적인 콘텐츠(HTML, CSS, 이미지 등)를 제공하는 서버
  - 기능 : HTTP 프로토콜을 이용해 클라이언트에게 웹 페이지 제공
  - 주요 소프트웨어 : Apache, Nginx, IIS
- WAS 서버
   - 정의 : 동적인 콘텐츠(웹 애플리케이션)를 처리하고 제공하는 서버
   - 기능 : 웹 애플리케이션 실행 및 데이터 처리, 웹 서버와 클라이언트 간의 중계 역할
   - 주요 소프트웨어 : 	Tomcat, JBoss, WebLogic, WebSphere
### 현대의 WAS는 Web Serving 능력이 출중하다고 합니다. 그런데도 왜 아직 둘을 나누는게 더 일반적일까요?
-	보안 강화: Web Server가 외부 요청을 필터링하고 WAS로 전달함으로써 보안 위협을 줄일 수 있습니다.
-	부하 분산: 정적 콘텐츠는 Web Server가 처리하고, 동적 콘텐츠는 WAS가 처리하여 시스템 부하를 효율적으로 관리할 수 있습니다.
-	유지보수 용이성: 각 서버를 독립적으로 관리하고 최적화할 수 있어 운영 효율성이 높아집니다.
-	스케일링 유연성: 트래픽 패턴에 따라 Web Server나 WAS를 개별적으로 확장할 수 있습니다.

### 우리가 보는 화면은 Web Server를 활용(빠르고 안정적), 우리의 데이터 관리 등은 WAS를 활용하게 되는 것 같다.
### 유명한 웹 서버-Apache, WAS서버-Tomcat. 이 둘을 사용하므로써 서버 부하를 방지.
### Tomcat5.5부터 Apache기능을 포함하게 되서, Apache Tomcat이라고 부름.
### WAS서버를 재시작할 때, Web Server에서 WAS 사용을 제한하면 사용자들의 불편을 줄일 수 있다.
### 이를 [장애 극복 기능] 이라고 한다.
![img.png](img.png)