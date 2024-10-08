# 요기다 정리

## Scan
```
package nextstep.helloworld.core.scan;

import org.springframework.stereotype.Repository;

@Repository
public class LineDao {
}

```

```
package nextstep.helloworld.core.scan;

import org.springframework.stereotype.Service;

@Service
public class LineService {
}

```
- @Repository와 @Service 어노테이션을 통해 LineDao, LineService가 스프링 빈으로 자동 등록됩니다.


## DI

```
package nextstep.helloworld.core.di;

import org.springframework.stereotype.Service;

@Service
public class StationConstructorService {
    private StationRepository stationRepository;

    public StationConstructorService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}

```
- 생성자 주입: StationConstructorService는 생성자를 통해 StationRepository를 주입받아 불변성을 보장하고, 테스트 용이성을 높입니다.
  
```
package nextstep.helloworld.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationSetterService {
    private StationRepository stationRepository;

    @Autowired
    public void setStationRepository(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}

```
세터 주입: StationSetterService는 세터 메서드를 통해 StationRepository를 주입받아 유연성을 제공합니다.


```
package nextstep.helloworld.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationFieldService {

    @Autowired
    private StationRepository stationRepository;

    public String sayHi() {
        return stationRepository.sayHi();
    }
}

```
- 필드 주입: StationFieldService는 필드에 직접 @Autowired 어노테이션을 사용하여 StationRepository를 주입받아 코드가 간결해집니다.

- @Service 어노테이션을 통해 StationConstructorService, StationSetterService, StationFieldService가 이 스프링 빈으로 자동 등록됩니다.



테스트 검증: ComponentScanTest와 DependencyInjectionTest를 통해 해당 빈들이 정상적으로 등록되고 의존성이 올바르게 주입되었는지 확인합니다.
