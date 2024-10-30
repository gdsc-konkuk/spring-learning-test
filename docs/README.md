### View Controller

Spring MVC에서 View Controller는 비즈니스 로직 없이 특정 요청을 바로 뷰로 연결하는 설정 단축 방식입니다. 이 방식은 정적 페이지나 뷰를 렌더링하기 전에 Java 코드 실행이 필요하지 않은
경우에 유용합니다.

Java 설정 예시
Java에서는 WebMvcConfigurer를 사용해 ParameterizableViewController를 설정하여, 루트 URL /에 대한 요청을 "home"이라는 뷰로 포워딩할 수 있습니다:

```java

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
```

### Handler Interceptor

**Handler Interceptor**는 Spring MVC에서 요청을 처리하는 **전/후 처리 작업**을 수행할 수 있는 기능입니다. 이 인터셉터는 특정 URL 패턴에 대해 사전, 사후 또는 완료 콜백을 실행할 수 있어 **인증, 로깅, 언어 설정, 테마 변경** 등의 작업에 유용합니다.

#### Handler Interceptor 메서드
Spring에서 제공하는 `HandlerInterceptor` 인터페이스는 다음과 같은 세 가지 주요 메서드를 가지고 있습니다:
- **preHandle**: 요청이 컨트롤러에 도달하기 전에 실행됩니다. 여기에서 `true`를 반환하면 요청이 계속 진행되고, `false`를 반환하면 이후의 처리가 중단됩니다.
- **postHandle**: 컨트롤러가 요청을 처리한 후, 뷰가 렌더링되기 전에 실행됩니다. 주로 요청 처리 후 추가 작업이 필요한 경우 사용됩니다.
- **afterCompletion**: 뷰가 완전히 렌더링된 후에 실행됩니다. 예외 처리 또는 자원 해제 등의 작업에 유용합니다.

다음 예제에서는 `WebConfig` 클래스에 `HandlerInterceptor`를 등록하는 설정을 보여줍니다.

```java
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new ThemeChangeInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/admin/**");
    }
}
