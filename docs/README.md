## View Controllers

뷰 컨트롤러는 화면 구성 요소들, 뷰를 관리하며 화면과 데이터 사이의 상호작용도 관리

컨트롤러 없이 특정 view에 대한 컨트롤러를 추가하는 방법

```java
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registy){
		registry.addViewController("/").setViewName("home");
```

```xml
<mvc:view-controller path="/" view-name="home"/>
```

위 코드는 같은 동작을 함

“/”라는 url이 요청되면 home이라는 view로 이동하도록 만들어 줌

만약 @RequestMapping 메서드가 http 메서드나 URL에 매핑되어 있을 경우 뷰 컨트롤러는 같은 URL에서 동작할 수 없음

## Interceptors

- interceptor란?

  애플리케이션의 요청과 응답을 가로채고 처리하는 기능을 제공하는 인터페이스

  일반적으로 로깅, 인증, 권한 부여와 같은 공통 작업을 행하는데 사용


```java
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.adddInterceptor(new LocaleChangeInterceptor());
		registry.addInterceptor(new ThemeChangeInterceptor()).addPathPattern("/**").excludePathPattern("/admin/**");
	}
}
```

- Interface HandlerInterceptor → LocalChangeInterceptor

  특정한 URI 호출을 가로채는 역할, 기존 컨트롤러의 로직을 수정하지 않고 제어가 가능


## Custom Argument Resolver

### Argument Resolver란?

컨트롤러 메서드의 파라미터 중 조건에 맞는 파라미터를 요청에 의해 들어온 값을 이용해 원하는 객체를 만들어 바인딩해주는 역할을 수행

### HandlerMethodArgumentResolver 인터페이스

주어진 요청에 의해 메서드 파라미터를 매개변수로 연결하는 인터페이스

### Custom Argument Resolver를 사용하는 방법

- 타깃 파라미터를 위한 어노테이션 정의

    ```java
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface Version{ }
    ```

    - @Retention: 라이프 사이클을 정의
        - RetentionPolicy.RUNTIME: 런타임까지 생존
        - RetentionPolicy.CLASS: 클래스 파일까지 생존
        - RetentionPolicy.SOURCE: 소스 코드까지 생존
    - @Target: 사용자가 만든 어노테이션이 부착될 수 있는 타입 지정
- Custom HandlerMethodArgumentResolver를 정의
    - supportsParameter 메서드: 해당 파라미터가 타입인지 확인, 어노테이션을 가지고있는지 확인
    - resolveArgument 메서드: 실제 바인딩할 객체를 만들어 리턴
- WebMvcConfigurer를 상속한 클래스의 addArgumentResolvers를 정의

  HandlerMethodArgumentResolver의 리스트를 전달맏아 새롭게 정의한 custom argumentresolver를 추가

- Contoller에서 사용 가능