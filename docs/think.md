# 생각해 볼까요?

> 다음은 알아두면 재밌을, 어쩌면 몰라도 크게 상관없을 내용들이기도 합니다.
> 
> 관심이 있는 주제(최소 1개)에 대해서 더 알아보고 스터디원과 생각을 교류해 봅시다!

1. **DI**란 무엇인가요?
   - Compile-time Dependency와 Run-time Dependency의 차이를 아시나요?
   - DI의 단점은 무엇일까요?
   - IoC Container 없이 DI를 하려면 어떤 불편함이 있을까요?
   - SOILD 원칙 각각의 단점에 대해 생각해보신적이 있나요? 어떤 단점이 있을까요?
2. **TEST**란 무엇이고 왜 하는 걸까요?
   - Test Coverage에 대해 아시나요? 몇 %의 Coverage가 현실적으로 목표로 할 만 한가요?
   - TDD와 BDD의 차이에 대해 아시나요?
   - aaa와 gwt에 대해 아시나요?
   - Functionality Test에는 어떤 종류가 있을까요? E2E, integration, unit Test에 대해 들어보셨나요?
   - Performance Test에는 어떤 종류가 있을까요? Load, Stress, Endurance Test에 대해 들어보셨나요?
   - 호오옥시... Chaos Engineering에 대해 아시나요?

# 아래에 정리해 주세요!

> 정리 양식은 자유입니다! 몇 가지 주제에 대해서 알아오셨나요?

**DI**란 무엇인가요?
- Dependency Injection (DI)는 객체 지향 프로그래밍에서 객체 간의 의존성을 관리하고 주입하는 디자인 패턴입니다. DI의 주요 목적은 객체가 자신의 의존성을 스스로 생성하거나 관리하지 않고, 외부에서 주입받아 사용하는 것입니다. 이를 통해 코드의 결합도를 낮추고, 유연성과 테스트 용이성을 향상시킬 수 있습니다.

> 주요 개념
- 의존성 (Dependency)
   - 한 객체가 다른 객체에 의존하는 관계를 말합니다. 예를 들어, UserService가 UserRepository에 의존한다면, UserService는 UserRepository를 필요로 합니다.    
- 주입 (Injection)
   - 주입 (Injection): 외부에서 의존성을 객체에 제공하는 과정입니다. DI는 의존성을 주입함으로써 객체 간의 결합도를 줄입니다. 
- Inversion of Control (IoC)
   - Inversion of Control (IoC): 제어의 역전이라고도 하며, 객체가 자신의 의존성을 직접 관리하지 않고 외부에서 주입받는다는 개념입니다. DI는 IoC의 한 형태입니다.

> DI의 유형
- 생성자 주입 (Constructor Injection): 객체의 생성자를 통해 의존성을 주입합니다.
   - 장점:
      - 불변성 보장: 의존성이 변경되지 않으므로, 객체의 상태가 안정적입니다.
      - 명확한 의존성 표시: 생성자 파라미터를 통해 어떤 의존성이 필요한지 명확히 알 수 있습니다.
      - 테스트 용이성: 테스트 시 의존성을 쉽게 주입할 수 있습니다. 
   - 단점:
      - 많은 생성자 파라미터: 의존성이 많아지면 생성자 파라미터가 많아져 코드가 복잡해질 수 있습니다.
      - 순환 의존성: 두 클래스가 서로를 의존할 경우 순환 의존성이 발생할 수 있습니다.
```
// 의존성 인터페이스
public interface UserRepository {
    void save(User user);
}

// 의존성 구현체
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {
        // 사용자 저장 로직
    }
}

// 의존성을 주입받는 클래스
public class UserService {
    private final UserRepository userRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}

```
- 세터 주입 (Setter Injection): 객체의 세터 메서드를 통해 의존성을 주입합니다.
   - 장점:
      - 선택적 의존성 주입: 의존성이 필수가 아닌 경우 유용합니다.
      - 유연성: 필요에 따라 의존성을 변경할 수 있습니다. 
   - 단점:
      - 불변성 부족: 의존성이 변경될 수 있어 객체의 상태가 불안정해질 수 있습니다.
      - 명확성 부족: 어떤 의존성이 필요한지 클래스 내부에서 명확히 알기 어렵습니다.
      - 테스트 복잡성: 테스트 시 의존성을 주입하기 위해 세터 메서드를 호출해야 하므로 번거로울 수 있습니다.
```
// 의존성 인터페이스
public interface UserRepository {
    void save(User user);
}

// 의존성 구현체
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {
        // 사용자 저장 로직
    }
}

// 의존성을 주입받는 클래스
public class UserService {
    private final UserRepository userRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}

```   
- 필드 주입 (Field Injection): 의존성을 객체의 필드에 직접 주입하는 방식입니다. 주로 어노테이션을 사용하여 의존성을 주입합니다.
   - 장점:
      - 간결성: 의존성을 주입하는 코드가 적어 코드가 간결해집니다.
      - 빠른 개발: 의존성을 빠르게 주입할 수 있어 개발 속도가 향상됩니다.
   - 단점:
      - 불변성 부족: 의존성이 변경될 수 있어 객체의 상태가 불안정해질 수 있습니다.
      - 명확성 부족: 클래스의 의존성을 외부에서 파악하기 어렵습니다.
      - 테스트 어려움: 의존성을 주입하기 위해 리플렉션 등을 사용해야 할 수 있어 테스트가 어려워질 수 있습니다.
      - 캡슐화 위반: 필드를 private으로 유지하면서도 외부에서 의존성을 주입하기 때문에 캡슐화 원칙을 위반할 수 있습니다.
```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }
}

```
> Compile-time Dependency와 Run-time Dependency의 차이를 아시나요?
- 의존성 관리는 소프트웨어 개발에서 중요한 개념으로, 의존성이 결정되는 시점에 따라 컴파일 타임 의존성 (Compile-time Dependency)과 런타임 의존성 (Run-time Dependency)으로 나눌 수 있습니다.
- 컴파일 타임 의존성 (Compile-time Dependency)
   - 컴파일 시점에 결정되는 의존성으로, 코드가 컴파일될 때 의존하는 모든 클래스와 라이브러리가 필요합니다.
   - 고정된 의존성: 컴파일 시점에 모든 의존성이 결정되므로, 의존성을 변경하려면 코드를 수정하고 재컴파일해야 합니다.
   - 조기 오류 발견: 잘못된 의존성은 컴파일 시점에 발견되어 런타임 오류를 줄일 수 있습니다.
```
public class UserService {
    private UserRepository userRepository = new UserRepositoryImpl();
    
    // 서비스 메서드
}

```
- 런타임 의존성 (Run-time Dependency)
   - 런타임 시점에 결정되는 의존성으로, 프로그램이 실행되는 동안 동적으로 의존성이 주입됩니다.
   - 유연한 의존성 관리: 의존성을 실행 중에 변경할 수 있어, 코드 변경 없이도 의존성을 교체할 수 있습니다.
   - 지연된 오류 발견: 잘못된 의존성은 런타임 시점에 발견될 수 있어, 컴파일 시점에 오류를 잡기 어렵습니다.
   
```
public class UserService {
    private UserRepository userRepository;
    
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // 서비스 메서드
}
// UserService는 UserRepository 인터페이스에 의존하며, 실제 구현체는 런타임 시점에 주입됩니다.
```
 
> DI의 단점은 무엇일까요?
- 복잡성 증가
   - DI를 도입하면 설정 파일이나 어노테이션을 사용하여 의존성을 관리해야 하므로 코드의 복잡성이 증가할 수 있습니다.
   - 큰 프로젝트에서 수많은 의존성을 관리하기 위해 복잡한 DI 설정이 필요할 수 있습니다. 
- 디버깅 어려움
   - DI를 통해 객체가 동적으로 주입되면, 디버깅 시 어떤 객체가 주입되었는지 추적하기 어려울 수 있습니다.
   - 특정 의존성이 제대로 주입되지 않아 발생하는 오류를 추적하는 것이 어려울 수 있습니다. 
- 과도한 추상화
   - DI를 과도하게 사용하면 코드가 지나치게 추상화되어 이해하기 어려워질 수 있습니다.
   - 모든 객체를 인터페이스로 분리하고 DI로 주입하면, 코드의 흐름을 따라가기가 어려워질 수 있습니다. 
- 성능 오버헤드
   - DI 컨테이너를 사용하는 경우, 객체 생성과 의존성 주입 과정에서 약간의 성능 오버헤드가 발생할 수 있습니다.
   - 애플리케이션 초기화 시 많은 객체를 생성하고 주입해야 하는 경우, 시작 시간이 길어질 수 있습니다. 
- 코드 가독성 저하
   - 의존성이 외부에서 주입되므로, 코드만 보고는 의존성 관계를 이해하기 어려울 수 있습니다.
   - 생성자나 세터를 통해 주입된 의존성을 추적하기 위해서는 추가적인 설정 파일이나 어노테이션을 확인해야 합니다. 
> IoC Container 없이 DI를 하려면 어떤 불편함이 있을까요?
- Inversion of Control (IoC) Container는 DI를 관리하고 객체의 생명주기를 처리하는 역할을 합니다. IoC 컨테이너 없이 DI를 구현하려면 여러 가지 불편함과 어려움이 발생할 수 있습니다.
- 수동 의존성 관리
   - 모든 의존성을 수동으로 생성하고 주입해야 하므로, 코드가 복잡해지고 반복적인 작업이 증가합니다.
```
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        
        // 애플리케이션 실행
    }
}

```
   - 의존성이 많은 경우, 각 객체를 수동으로 생성하고 주입하는 코드가 많아져 관리가 어려워집니다.
-  코드 중복
   - 의존성 주입을 위한 반복적인 코드가 많아져 유지보수가 어려워집니다.
```
public class Main {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA(new RepositoryA());
        ServiceB serviceB = new ServiceB(new RepositoryB());
        ServiceC serviceC = new ServiceC(new RepositoryC());
        
        // 애플리케이션 실행
    }
}

```
   - 각 서비스마다 별도로 의존성을 생성하고 주입해야 하므로, 코드 중복이 발생합니다.   
  
- 유연성 저하
   - 의존성을 동적으로 변경하거나 교체하기 어렵고, 새로운 의존성을 추가할 때마다 코드를 수정해야 합니다.
```
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        
        // 나중에 다른 구현체로 교체하려면 코드 수정 필요
        userRepository = new AlternativeUserRepositoryImpl();
        userService.setUserRepository(userRepository);
    }
}
```
   - 의존성 구현체를 변경하려면 코드 수정이 필요하며, 이는 유지보수성과 확장성을 저하시킵니다.
- 테스트 어려움
   - 테스트 시 의존성을 주입하기 위해 별도의 설정이나 목 객체를 수동으로 생성해야 합니다.
```
@Test
public void testUserService() {
    UserRepository mockRepository = mock(UserRepository.class);
    UserService userService = new UserService(mockRepository);
    
    // 테스트 실행
}
```
   - 각 테스트마다 의존성을 수동으로 설정해야 하므로, 테스트 코드가 복잡해지고 반복적입니다.
- 생명주기 관리 어려움
   - 객체의 생성과 소멸을 직접 관리해야 하므로, 메모리 누수나 리소스 관리 문제가 발생할 수 있습니다.
```
public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        UserService userService = new UserService(dbConnection);
        
        // 애플리케이션 종료 시 dbConnection 닫기 필요
        dbConnection.close();
    }
}
```
   - 모든 의존성 객체를 수동으로 생성하고 관리해야 하므로, 리소스 관리에 신경 써야 합니다.
- 확장성 문제
   - 애플리케이션이 커지면 커질수록 의존성 관리가 더욱 복잡해져 확장성이 떨어집니다.
```
public class Main {
    public static void main(String[] args) {
        // 의존성이 많아질수록 생성과 주입이 복잡해짐
        ServiceA serviceA = new ServiceA(new RepositoryA());
        ServiceB serviceB = new ServiceB(new RepositoryB());
        ServiceC serviceC = new ServiceC(new RepositoryC());
        // ... 계속 추가
    }
}
```
   - 의존성이 많아질수록 코드가 복잡해지고 관리하기 어려워집니다.


**TEST**란 무엇이고 왜 하는 걸까요?
- 테스트(Test)는 소프트웨어 개발 과정에서 소프트웨어가 요구사항을 충족하고 예상대로 동작하는지 확인하기 위해 수행되는 과정입니다. 테스트는 소프트웨어의 품질을 보장하고, 오류나 결함을 사전에 발견하여 수정함으로써 안정적이고 신뢰할 수 있는 제품을 제공하는 것을 목표로 합니다.
- 테스트의 주요 유형
   - 단위 테스트(Unit Test): 개별 모듈이나 함수 단위로 테스트하여, 각 단위가 올바르게 동작하는지 확인합니다.
   - 통합 테스트(Integration Test): 여러 모듈이 함께 동작하는지 테스트하여, 모듈 간의 상호작용을 확인합니다.
   - 기능 테스트(Functionality Test): 소프트웨어의 기능이 요구사항을 충족하는지 테스트합니다.
   - 시스템 테스트(System Test): 전체 시스템이 올바르게 동작하는지 테스트합니다.
   - 인수 테스트(Acceptance Test): 최종 사용자의 요구사항을 충족하는지 테스트하여, 소프트웨어가 실제 사용 환경에서 적합한지 확인합니다.
   - 회귀 테스트(Regression Test): 코드 변경 후 기존 기능이 정상적으로 동작하는지 테스트합니다.
   - 성능 테스트(Performance Test): 소프트웨어의 성능을 평가하여, 응답 시간, 처리량, 자원 사용 등을 확인합니다.
 
     
> Performance Test에는 어떤 종류가 있을까요? Load, Stress, Endurance Test에 대해 들어보셨나요?
- Performance Test는 소프트웨어의 성능 특성을 평가하는 테스트 유형으로, 시스템이 특정 조건 하에서 어떻게 동작하는지 측정합니다. 성능 테스트는 사용자 경험을 개선하고, 시스템의 안정성과 효율성을 보장하는 데 중요한 역할을 합니다. 성능 테스트의 주요 유형에는 Load Test, Stress Test, Endurance Test 등이 있습니다.
   - Load Test (부하 테스트): 시스템이 정상적인 조건에서 예상되는 부하를 얼마나 잘 처리할 수 있는지를 평가하는 테스트입니다.
      - 목적:
         - 시스템의 성능 한계를 파악하여, 예상 트래픽을 안정적으로 처리할 수 있는지 확인합니다.
         - 응답 시간, 처리량, 자원 사용량 등을 측정하여, 시스템의 성능을 최적화합니다.
      - 특징:
         - 예상 트래픽 시뮬레이션: 실제 사용 환경에서 예상되는 사용자 수나 요청 수를 시뮬레이션합니다.
         - 성능 지표 측정: 응답 시간, 처리량, CPU 및 메모리 사용량 등의 성능 지표를 측정합니다.
         - 문제점 파악: 시스템이 정상적인 부하에서도 안정적으로 동작하는지 확인하고, 병목 현상이나 성능 저하 문제를 발견합니다.
      - 예시:
         - 동시에 100명의 사용자가 웹 애플리케이션에 접속하여 페이지를 요청할 때의 응답 시간을 측정합니다.
         - API 서버에 초당 1000개의 요청을 보내고 처리 속도를 평가합니다.
   - Stress Test (스트레스 테스트): 시스템의 최대 용량을 초과하는 극한의 부하를 가하여, 시스템이 어떻게 동작하고 어떤 한계에서 실패하는지를 평가하는 테스트입니다.
      - 목적:
         - 시스템의 한계점(최대 처리 용량)을 파악합니다.
         - 장애 발생 시 시스템의 복원력과 안정성을 평가합니다.
         - 시스템이 극한 조건에서 어떻게 반응하는지 확인하여, 실제 장애 상황에 대한 대비를 합니다.
      - 특징:
         - 극한 부하 시뮬레이션: 시스템이 처리할 수 있는 최대 부하를 넘어서도록 시뮬레이션합니다.
         - 장애 시나리오 검증: 시스템이 과부하 상태에서 어떻게 동작하는지, 장애 복구 과정이 제대로 작동하는지 확인합니다.
         - 성능 한계 파악: 시스템이 언제 성능 저하를 겪거나, 장애를 일으키는지 파악합니다.
      - 예시:
         - 웹 서버에 초당 10,000개의 요청을 보내어, 서버가 과부하 상태에 도달할 때까지 테스트합니다.
         - 데이터베이스 서버에 무리한 쿼리 요청을 보내고, 서버의 응답과 복원 과정을 평가합니다.
   - Endurance Test (지속성 테스트) 또는 Soak Test: 장시간 동안 지속적인 부하를 가하여, 시스템의 안정성과 메모리 누수 등을 평가하는 테스트입니다.
      - 목적:
         - 시스템이 장기간 운영될 때도 안정적으로 동작하는지 확인합니다.
         - 메모리 누수, 자원 고갈 등 장기적인 문제를 발견하여, 시스템의 신뢰성을 높입니다.
         - 시스템의 장기적인 성능 변화를 관찰하여, 지속적인 최적화가 필요한 부분을 식별합니다.
      - 특징:
         - 장기적인 부하 시뮬레이션: 수 시간 또는 수 일 동안 지속적인 부하를 유지합니다.
         - 자원 사용 모니터링: 메모리, CPU, 디스크 사용량 등 자원 사용량을 지속적으로 모니터링합니다.
         - 안정성 검증: 시스템이 장기적으로 안정적으로 운영될 수 있는지 평가합니다.
      - 예시:
         - 웹 애플리케이션에 하루 종일 지속적으로 동일한 부하를 가하여, 메모리 누수나 자원 고갈 문제를 확인합니다.
         - 데이터베이스 서버에 24시간 동안 지속적인 쿼리 요청을 보내고, 서버의 안정성과 성능 변화를 평가합니다.

- Performance Test 도구 예시
   - Load Test 도구:
      - Apache JMeter: 오픈 소스 성능 테스트 도구로, 웹 애플리케이션의 부하 테스트에 널리 사용됩니다.
   - Stress Test 도구:
      - k6: 현대적인 부하 테스트 도구로, 스크립트 기반의 스트레스 테스트를 지원합니다.
   - Endurance Test 도구:
      - BlazeMeter: 장기간 부하 테스트를 지원하는 클라우드 기반 도구로, 지속적인 테스트를 쉽게 수행할 수 있습니다.
      - Loader.io: 간단한 인터페이스를 통해 장기적인 부하 테스트를 수행할 수 있는 도구입니다.
     
