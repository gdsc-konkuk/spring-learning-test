# 요기다 정리
## WebMvcConfig는 Spring MVC의 동작 방식을 커스터마이징하거나 특정 기능을 설정할 때 사용
### **addInterceptors-인터셉터** 
는 Spring MVC에서 요청(Request)와 응답(Response)의 흐름을 가로채서 추가 작업을 수행할 수 있는 기능을 제공합니다. 쉽게 말해서, 클라이언트가 서버에 요청을 보낼 때, 요청을 가로채어 사전 처리나 후처리를 할 수 있는 역할을 합니다.

인터셉터의 역할

인터셉터는 요청과 응답의 특정 지점에서 추가적인 작업을 할 수 있는 기회를 제공합니다. 인터셉터는 주로 다음의 역할을 수행합니다:

	1.	요청 전 처리 (preHandle): 컨트롤러 메서드가 실행되기 전에 요청을 가로채서 처리합니다. 여기에서 요청을 검사하거나 인증/권한을 확인하는 등의 작업을 수행할 수 있습니다.
	2.	요청 후 처리 (postHandle): 컨트롤러 메서드가 실행된 후, 뷰가 렌더링되기 전에 호출됩니다. 이 단계에서는 모델에 추가적인 데이터를 넣거나 응답을 수정할 수 있습니다.
	3.	완료 후 처리 (afterCompletion): 뷰 렌더링이 완료된 후에 호출됩니다. 주로 로그를 기록하거나 리소스를 해제하는 등의 작업을 합니다.

인터셉터와 필터의 차이점

**필터 Filter**는 서블릿 수준에서 동작하고, 요청과 응답의 흐름을 제어할 수 있습니다. 반면에 인터셉터는 Spring MVC 수준에서 동작하고, 컨트롤러의 실행 전후에 추가적인 처리를 수행할 수 있습니다. 다음은 주요 차이점입니다:

	•	필터: 서블릿 컨테이너에서 동작하며 Spring MVC에 국한되지 않습니다. 모든 서블릿 요청을 처리할 수 있습니다.
	•	인터셉터: Spring MVC에 특화되어 있으며, 컨트롤러의 실행 전, 후 및 뷰 렌더링 전후에만 동작합니다. Spring과 더 밀접하게 통합되어 있습니다.

```registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**");```<br>
``"/admin/**"``주소 패턴을 ``InterceptorRegistration-includePatterns 필드에 추가``<br>,
``LoginInterceptor``를``InterceptorRegistry-registrations필드에 추가``<br>
여기서 자바의 다형성에 다시한번 감탄을..ㅠ
``LoginInterceptor``가 어떻게 바로 ``InterceptorRegistry``로 들어가냐 하면..<br>
``HandlerInterceptor`` 형으로 들어와야 함. ``LoginIntercepter`` 은 ``HandlerInterceptorAdapter`` 를 상속하고..그 끝은 ``HandlerInterceptor`` 인터페이스

---
### **addArgumentResolvers** 

addArgumentResolvers() 메서드는 Spring MVC에서 제공하는 WebMvcConfigurer 인터페이스의 메서드로, 사용자 정의 Argument Resolver를 등록하여 컨트롤러 메서드의 파라미터를 자동으로 주입할 수 있도록 하는 기능을 제공합니다.


##### Argument Resolver란?

Argument Resolver는 Spring MVC에서 컨트롤러 메서드의 파라미터를 처리하여 자동으로 주입해주는 역할을 합니다. 기본적으로 Spring MVC는 요청 파라미터, URL 경로 변수, 헤더 값, 바디 등을 처리하기 위해 여러 기본 제공 Resolver를 사용하지만, 필요에 따라 사용자 정의 Argument Resolver를 통해 컨트롤러 파라미터를 커스터마이징할 수 있습니다.

사용 이유

	•	복잡한 파라미터 처리 로직을 단순화: 컨트롤러에서 반복적으로 처리해야 하는 요청 데이터 가공 작업을 Argument Resolver로 구현해 코드 중복을 줄일 수 있습니다.
	•	✨인증 정보 주입✨: 컨트롤러 메서드에 로그인한 사용자 정보를 자동으로 주입하기 위해 사용됩니다.
	•	특정 객체 변환: 요청에서 얻은 데이터를 특정 형태의 객체로 변환하여 주입하는 경우에도 사용됩니다.
---
addViewControllers() 메서드는 Spring MVC의 WebMvcConfigurer 인터페이스에서 제공하는 메서드 중 하나로, 특정 URL 요청을 직접적인 비즈니스 로직 없이 정적 뷰(view)로 매핑할 때 사용합니다. 이 메서드를 통해, URL과 정적 페이지를 손쉽게 연결할 수 있습니다.

addViewControllers()는 다음과 같은 경우에 유용합니다:

	•	특정 URL 요청을 처리하는데 비즈니스 로직이 필요 없는 경우.
	•	단순히 정적 HTML 페이지를 보여주거나, 특정 JSP 파일을 응답할 때 사용합니다.
