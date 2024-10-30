# Mapping

### Request Mapping

`@RequestMapping` annotation을 사용하여 url, http method, request parameters, headers, media types를 매칭할 수 있다.
구체적으로 아래와 같이 명시 할 수도 있다.

- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@PatchMapping`

이런 구체적으로 명시된 매핑 애노테이션들도있지만 여전히 공통 http method를 매핑하는 `@RequestMapping`은 여전히 필요함을 잊지말자

### URI Patterns

`@RequestMapping` method의 경우 URL 패턴으로 mapping 될 수 있다
이 대안으로 `@PathPattern`이나 `@AntPathMatcher`가 있긴한데, WebFlux 등에서 주로 사용하고있다.

URI로 capture된 변수들은 `@PathVariable`로 사용할 수 있다.
```java
@GetMapping("/owners/{ownerId}/pets/{petId}")
public Pet findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
	// ...
}
```
메소드에서만 `@PathVariable`을 사용할 수 있는건 아니다. 클래스 수준에서도 사용가능
```java
@Controller
@RequestMapping("/owners/{ownerId}")
public class OwnerController {

	@GetMapping("/pets/{petId}")
	public Pet findPet(@PathVariable Long ownerId, @PathVariable Long petId) {
		// ...
	}
}
```

URI 변수들은 자동으로 적절한 타입으로 변환되며, 변환에 실패한 경우 `TypeMismatchException` 을 발생한다. `int`, `long`, `Date` 같은 타입은 기본적으로 지원된다.

### Consumable Media Types
같은 uri에서도 들어오는 `Content-Type`을 가지고 함수의 동작을 세분화 할 수 있다.
```java
@PostMapping(path = "/pets", consumes = "application/json")
public void addPet(@RequestBody Pet pet) {
	// ...
}
```
`consumes` 속성은 부정(!)의 요소도 지정 가능한데,
예를들어 `!text/plain` 은 `text/plain` 이 아닌 모든 data type을 쓴다.

### Producible Media Types
같은 uri에서도 들어오는 `Accept` 속성을 가지고 함수의 동작을 세분화 할 수 있다.
```java
@GetMapping(path = "/pets/{petId}", produces = "application/json")
@ResponseBody
public Pet getPet(@PathVariable String petId) {
	// ...
}
```
`produces` 속성도 마찬가지로, 부정(!)의 요소가 가능하다.

### Parameters, Headers
같은 uri에서도 들어오는 `request parameter conditions` 속성을 가지고 함수의 동작을 세분화 할 수 있다.
```java
@GetMapping(path = "/pets/{petId}", params = "myParam=myValue")
public void findPet(@PathVariable String petId) {
	// ...
}
```
```java
@GetMapping(path = "/pets/{petId}", headers = "myHeader=myValue")
public void findPet(@PathVariable String petId) {
	// ...
}
```

---

# Spring MVC - Method Arguments

### 1. HTTP 요청 요소 기반 인수
- **@RequestParam**:  
  URL 쿼리 파라미터나 폼 데이터를 통해 전달되는 요청 파라미터를 메소드 인수로 받아옵니다.  
  예시: `@RequestParam("name") String name`
    - `required` 속성을 통해 필수 여부를 지정할 수 있으며, `required=false`로 설정하거나 `Optional`을 사용할 수 있습니다.

- **@PathVariable**:  
  URL 경로에 포함된 변수 값을 추출하는 데 사용됩니다.  
  예시: `@GetMapping("/users/{id}")` -> `@PathVariable("id") Long userId`

- **@RequestHeader**:  
  HTTP 헤더 값을 메소드 인수로 전달합니다.  
  예시: `@RequestHeader("User-Agent") String userAgent`
    - `required` 속성으로 필수 여부를 설정할 수 있으며, 기본값을 설정하는 `defaultValue`도 사용할 수 있습니다.

- **@CookieValue**:  
  특정 쿠키 값을 메소드 인수로 받아옵니다.  
  예시: `@CookieValue("JSESSIONID") String sessionId`

### 2. 요청 본문(body) 기반 인수
- **@RequestBody**:  
  HTTP 요청의 본문을 메소드 인수로 매핑하여 직접 사용할 수 있습니다. 주로 JSON, XML과 같은 구조화된 데이터를 객체로 변환하는 데 사용됩니다.  
  예시: `@RequestBody User user`

- **HttpEntity<T> 및 RequestEntity<T>**:  
  HTTP 요청 전체를 나타내는 `HttpEntity`는 헤더와 본문을 포함하여 요청 전체를 처리할 수 있게 합니다.  
  `RequestEntity`는 추가적으로 HTTP 메소드 및 URI 정보까지 포함합니다.

### 3. HTTP 응답(body) 설정을 위한 인수
- **ResponseEntity<T>**:  
  컨트롤러 메소드의 반환 타입으로 주로 사용되며, HTTP 응답 상태 코드, 헤더, 본문 데이터를 함께 전달할 수 있습니다.  
  예시: `return ResponseEntity.ok(user);`

- **HttpServletResponse**:  
  `HttpServletResponse`는 서블릿 API에서 제공하는 클래스로, 응답을 직접 작성하고 세부 설정이 가능합니다.  
  예시: `response.setStatus(HttpServletResponse.SC_OK);`

### 4. 세션 및 인증 관련 인수
- **@SessionAttribute**:  
  현재 세션에서 특정 속성(attribute)을 가져와 메소드 인수로 전달받습니다.  
  예시: `@SessionAttribute("user") User user`

- **@SessionAttributes**:  
  클래스 레벨에서 사용하며, 해당 컨트롤러에서 지속적으로 사용할 세션 데이터를 정의할 때 사용합니다. `@ModelAttribute`와 함께 사용하여 세션을 유지하게 할 수 있습니다.

- **@AuthenticationPrincipal**:  
  Spring Security와 통합하여 인증된 사용자의 정보를 메소드 인수로 전달받을 수 있습니다.  
  예시: `@AuthenticationPrincipal UserDetails userDetails`

### 5. 모델과 폼 데이터 관련 인수
- **@ModelAttribute**:  
  모델 객체를 메소드 인수로 받거나 메소드의 반환값을 모델에 추가합니다. 주로 폼 데이터를 처리할 때 사용됩니다.  
  예시: `@ModelAttribute User user`

- **Model, ModelMap, ModelAndView**:  
  `Model`과 `ModelMap`을 사용해 뷰로 데이터를 전달합니다.  
  `ModelAndView`는 모델 데이터와 뷰 이름을 한 번에 설정할 수 있습니다. 예시: `return new ModelAndView("viewName", model);`

---

# Spring MVC - Return Values
Spring MVC에서는 컨트롤러 메소드가 다양한 형식으로 응답할 수 있도록 여러 가지 반환 타입을 지원합니다. 각 반환 타입은 특정한 방식으로 HTTP 응답을 구성하거나 뷰로 데이터를 전달하는 데 사용됩니다.

### 1. 뷰 이름 (String)
- **String**:  
  컨트롤러 메소드가 `String`을 반환할 경우, Spring은 이를 뷰 이름으로 해석하고 해당 뷰를 렌더링합니다.  
  예시: `return "home";`
  - 위의 예시는 `home.jsp`와 같은 뷰 파일을 찾아서 반환하는 방식입니다.

### 2. ModelAndView
- **ModelAndView**:  
  `ModelAndView` 객체는 뷰 이름과 모델 데이터를 함께 포함할 수 있어, 메소드에서 모델과 뷰를 한 번에 설정할 수 있습니다.  
  예시: `return new ModelAndView("viewName", "modelKey", modelValue);`
  - 이 방식은 보다 명시적으로 뷰와 모델을 설정할 수 있어, 뷰와 모델 데이터를 모두 반환하고자 할 때 유용합니다.

### 3. @ResponseBody 또는 @RestController 사용
- **@ResponseBody**:  
  메소드가 객체를 반환할 때, `@ResponseBody` 애노테이션을 사용하면 해당 객체를 JSON 또는 XML로 변환하여 HTTP 응답의 본문으로 직접 반환합니다.  
  예시: `@ResponseBody public User getUser() { return new User(); }`
  - **@RestController**: 컨트롤러 클래스에 `@RestController` 애노테이션을 적용하면 클래스 내 모든 메소드에 `@ResponseBody`가 적용된 것과 같은 효과를 줍니다.

### 4. ResponseEntity<T>
- **ResponseEntity<T>**:  
  `ResponseEntity`는 상태 코드, 헤더, 본문 데이터를 포함하여 응답을 세부적으로 설정할 수 있는 타입입니다.  
  예시: `return ResponseEntity.ok(user);`
  - `ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found")`와 같이 상태 코드를 명시하여 보다 유연하게 응답을 조정할 수 있습니다.

### 5. Void
- **Void**:  
  반환 타입이 `void`일 때는 별도의 응답 데이터를 설정하지 않고, HTTP 응답 코드만을 설정하거나 `HttpServletResponse`로 직접 작성할 수 있습니다.  
  예시: `public void handleRequest(HttpServletResponse response) { response.setStatus(HttpServletResponse.SC_OK); }`
  - 리다이렉트가 필요할 경우에는 `redirect:/path`로 리다이렉트를 설정할 수 있습니다.

### 6. @ModelAttribute
- **@ModelAttribute**:  
  반환 타입에 `@ModelAttribute`를 사용하면 반환된 객체가 모델에 추가되어 뷰에서 사용될 수 있습니다. 이때, 메소드가 `String`을 반환하면 뷰 이름으로 해석됩니다.  
  예시: `@ModelAttribute("user") public User getUser() { return new User(); }`
  - 메소드에 직접 `@RequestMapping`을 사용하지 않고 `@ModelAttribute`로 모델 데이터를 설정할 때 유용합니다.

### 7. HttpEntity<T> 및 RequestEntity<T>
- **HttpEntity<T> 및 RequestEntity<T>**:  
  HTTP 요청이나 응답의 헤더와 본문 데이터를 포함하는 객체로, 요청에 대한 응답을 보다 구체적으로 설정할 수 있습니다.  
  예시: `return new HttpEntity<>(user);`
  - `HttpEntity`는 요청이나 응답 본문을 설정하는 데 사용됩니다. `RequestEntity`는 요청을 위한 `HttpMethod`나 URI 정보를 포함합니다.

### 8. HttpServletResponse
- **HttpServletResponse**:  
  서블릿 API의 `HttpServletResponse`를 직접 사용하여 응답을 작성할 수 있습니다.  
  예시: `response.getWriter().write("Hello World");`
  - 상태 코드나 헤더를 직접 설정하고, 응답 본문을 작성하는 경우에 유용합니다.

### 9. RedirectView
- **RedirectView**:  
  특정 URL로 리다이렉트할 때 사용됩니다.  
  예시: `return new RedirectView("/home");`
  - 특정 경로로 리다이렉트를 원할 때 편리하게 사용할 수 있으며, `@RequestMapping`이 적용된 다른 메소드로 리다이렉트할 수 있습니다.