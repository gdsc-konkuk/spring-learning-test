# 1. MVC(Model-View-Controller)
- - -
## 1.1 정의
- Application을 세 가지 역할로 분리하여 개발하는 아키텍쳐 패턴

## 1.2. 구성
![MCV 구조](https://developer.mozilla.org/ko/docs/Glossary/MVC/model-view-controller-light-blue.png)
출처: [mdn web docs](https://developer.mozilla.org/ko/docs/Glossary/MVC)

### 1.2.1. Model
- 데이터와 비지니스 로직 관리

### 1.2.2. View
- 데이터를 시각적으로 표시

### 1.2.3. Controller
- 요청을 적절한 Model과 View를 선택하여 처리

## 1.3. 장단점
### 1.3.1. 장점
- 역할 분리: 화면과 비지니스 로직의 분리
- 유연성, 확장성: UI(View)와 Data(Model)를 독립적으로 변경 가능
- 협업 용이: FE(View), BE(Model)로 분리 작업 가능

### 1.3.2. 단점
- 초기 학습 곡선

# 2. Spring Web MVC
- - -
## 2.1. 정의
- Spring Framework가 제공하는 MVC 기반 Web Application Framework

## 2.2. 구성

![Spring Dispather 구조](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/images/mvc.png)
출처: [Spring Docs](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html)

## 2.3. WebMvcConfigurer
### 2.3.1. 정의
- Spring MVC의 설정을 커스터마이징 할 수 있는 인터페이스

### 2.3.2. 사용
- WebMvcConfigurer 구현 후 필요 메소드가 오버라이드하여 사용

### 2.3.3. 주요 메소드
1. addInterceptors(InterceptorRegistry registry)
   - Spring MVC 요청 처리 흐름에 인터셉터 추가
   - 특정 경로에 접근하기 전 인증, 로깅, 또는 요청/응답을 가로채는 작업을 수행할 때 사용

2. addViewControllers(ViewControllerRegistry registry)
   - 특정 URL을 뷰(View)로 직접 매핑
   - 로그인 페이지와 같은 간단한 뷰 페이지를 컨트롤러 로직 없이 URL에 바로 매핑하고자 할 때 유용

3. addResourceHandlers(ResourceHandlerRegistry registry)
   - 정적 리소스 (예: CSS, JS, 이미지 파일)의 위치와 핸들러를 설정
   - /static 경로를 지정해 CSS나 JavaScript 파일을 서빙하거나, CDN을 사용해 정적 리소스를 로드하도록 설정할 때 사용

4. configureViewResolvers(ViewResolverRegistry registry)
   - **뷰 리졸버(View Resolver)를** 설정하여 템플릿 엔진과 뷰 파일 경로를 지정할
   - JSP, Thymeleaf와 같은 템플릿 엔진을 사용할 때 뷰 파일 위치와 이름 접두사 및 접미사 설정

5. addCorsMappings(CorsRegistry registry)
   - CORS(Cross-Origin Resource Sharing) 규칙을 설정하여 다른 도메인에서의 요청을 허용
   - 외부 프론트엔드 애플리케이션에서 백엔드 API를 호출할 때 도메인 차단을 방지하는 데 사용

6. configureMessageConverters(List<HttpMessageConverter<?>> converters)
   - HTTP 요청/응답의 데이터 변환 방식을 설정
   - JSON, XML 변환을 커스터마이징하거나, 커스텀 메시지 컨버터를 추가하여 데이터를 변환

7. addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers)
   - 컨트롤러 메서드의 파라미터를 커스터마이징할 수 있는 HandlerMethodArgumentResolver를 추가
   - @AuthenticationPrincipal처럼 특정 어노테이션이 있는 파라미터에 사용자 정보를 주입할 때 사용

8. configurePathMatch(PathMatchConfigurer configurer)
   - URL 경로 매칭 전략을 설정
   - 경로 접두사 설정이나 URL 경로 대소문자 구분 여부 설정을 커스터마이징

### 2.3.4. Controller VS Resolver
#### 2.3.4.1. Controller
- 역할: 요청 처리, 응답 반환

#### 2.3.4.2. Resolver
- 역할: 컨트롤러 메서드의 파라미터에 특정 데이터 자동 주입, 특정 형식으로 파라미터 처리 도움