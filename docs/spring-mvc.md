# MVC mission
## 요청

request: 클라이언트에서 서버로 통신하는 메시지

response: 서버에서 클라이언트로 통신하는 메시지

서버와 클라이언트간의 비동기 통신을 위해 본문에 데이터를 담아서 보내야하는데 이 본문을 body라고 함

본문에 담기는 데이터 형식은 대부분 JSON 형식

### JSON

Java Script Object Notation

Javascript 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기반의 표준 포맷

키와 값으로 이루어진 데이터 오브젝트를 전달하는 역할을 수행

### ResponseBody

자바 객체를 HTTP요청의 바디내용으로 직렬화(자바 언어에서 사용되는 객체 또는 데이터를 바이트 스트림 형태로 연속적인 데이터로 변환하는 포맷 기술)해 클라이언트로 전송

```java
@GetMapping("/accounts/{id}")
@ResponseBody
public Account handle(){
	//...
}
```

### RequestBody

바디를 요청하고 객체를 HttpMessageReader를 통해 역직렬화(바이트로 변환된 데이터를 원래대로 자바 시스템의 객체나 데이터로 변환) 작업을 수행

```java
@PostMapping("/accounts")
public void handle(@@RequestBody Account account) { 
	/...
}
```

### RequestParam

쿼리의 파라미터를 추출하고 파라미터를 사용하기 위한 작업을 수행

Http 요청 파라미터의 이름이 변수 이름과 같을 경우 value 값을 생략가능하지만 다를 경우 value를 통해 path-variable을 지정해줘야 함

변수가 단순 타입일 경우 이름을 생략가능

디폴트 필수여부는 true이지만 반드시 필요한 파라미터가 아니라면 required를 false로 설정

defaultValue 옵션을 통해 기본값 역시 지정 가능

- 생략 가능 관련: 스프링 부트 3.2부터 자바 컴파일러에 -parameters 옵션을 넣어줘야 애노테이션의 이름 생략 가능

### ModelAttribute

모델 객체에 요청 파라미터를 바인딩 하는 역할

Setter 메서드나 생성자가 필수적으로 필요

- @ModelAttribute와의 차이점

  RequestParam은 한번에 하나의 파라미터를 매핑하고 ModelAttribute는 다수의 파라미터를 맵핑한다는 차이점도 있지만 RequestParam은 오직 request parameter에서만 값을 매핑하지만 ModelAttribute는 requst parameter와 requestbody의 값 역시 매핑

  RequestParam은 단순히 파라미터 바인딩만 한다면 ModelAttribute는 다양한 유효성 검사를 진행 → 요청 파라미터를 받아 객체 생성부터 값 바인딩, 모델에 담아주는 작업까지 모두 수행


## Exception

### ExceptionHandler

@ExceptionHandler 어노테이션 통해 controller 계층의 특정 익셉션을 처리하기 위한 메서드를 정의할 수 있음

value 값으로 어떤 Excpetion을 처리할 것인지 넘겨 줄 수 있고 정의하지 않을 경우 모든 Exception을 처리

코드에선 ResponseEntity를 통해 BAD_REQUEST status인 ResponseEntity.BodyBuilder를 생성하고 body를 exception 이름으로 하는 ResponseEntity를 생성해 반환

### ControllerAdvice

특정 controller가 아닌 어플리케이션 전체의 익셉션을 처리하고 싶은 경우 사용, @RequestMapping이 달린 메서드 실행 중 발생한 예외를 처리

@ControllerAdvice 어노테이션을 가진 클래스는 controller-advice로 내부의 @Component 어노테이셔늘 통해 스프링 빈으로 등록

- 장점
    - 모든 컨트롤러의 예외를 하나의 클래스로 처리 가능
    - 일관성이 있는 에러 응답 가능

### RestController

@Controller에 @ResponseBody가 추가된 형태로 JSON 형태로 객체를 반환하는 역할을 수행

## RequestMapping

컨트롤러의 메서드와 요청을 매핑하기위해 사용

- String[] consumes: 매핑된 핸들러가 소비할 미디어 타입의 목록을 지정
- Stringp[] headers: 매핑된 요청의 헤더
- RequestMethod[] method: 매핑할 특정 HTTP 요청의 종류

  GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE

- String name: 매핑의 이름
- Stringp[] params: 매핑된 요청의 파라미터
- String[] path: URI의 경로
- String[] produces: 매핑된 핸들러로 생성될 미디어 타입을 제한
- String[] value: URI의 경로

### PostMapping

HTTP POST 요청을 처리하는 handler 메서드를 위한 어노테이션

@RequestMapping(method = RequestMethod.POST)와 같은 역할을 수행

같은 메서드에 대해 여러개의 @ReqeustMapping 어노테이션을 사용할경우 첫번째 매핑만 사용됨

- 경로를 지정해 사용

### GetMapping

HTTP GET 요청을 처리하는 handler 메서드를 위한 어노테이션

@RequestMapping(method = RequestMethod.GET)와 같은 역할을 수행

이 외에도 @PutMapping, @DeleteMapping, @PatchMapping 등의 RequestMapping의 축약이 존재

## PathVariable

경로 변수를 표시하기 위해 메서드에 매개변수에 사용

```java
@GetMapping("/api/employees/{id}")
@ResponseBody
public String getEmployeeById(@PathVariable String id){
	return "ID: "+id;
}
```

@PathVariable을 통해 URI의 식별자를 추출

URI의 {postId}와 매개변수의 이름을 맞춰줘야하고 path-variable과 메서드에 사용할 변수명을 다르게 사용하고 싶을 경우 어노테이션의 값으로 path-variable의 이름을 전달

여러 개의 PathVariable 동시에 사용 가능