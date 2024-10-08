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

### Test Doubles

1. `Dummy` : 사용하지 않을 객체 (단순히 인자로 넘기기 위한 객체)
2. `Fake` : 테스트만을 위한 단순한 객체 (e.g., in-memory repository)
3. `Stub` : 가상의 State를 위한 객체 (응답에 대해 반환값을 미리 만들어둔 객체)
4. `Spy` : `Stub` + 호출에 대한 기록 저장 (e.g., `assert(spy.calledWith(5))`)
5. `Mock` : 가상의 Behavior를 위한 객체

> 참고: https://martinfowler.com/articles/mocksArentStubs.html

> **TIP**. `Mockito`에서 `Mock`과 `Spy`의 차이는,
> 덮어쓰지 않은 행위에 대해 어떻게 동작하느냐를 위주로 바라보면 편합니다.
>
> 참고: https://www.baeldung.com/mockito-spy
