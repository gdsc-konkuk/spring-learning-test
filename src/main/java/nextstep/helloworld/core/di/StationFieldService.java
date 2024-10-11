package nextstep.helloworld.core.di;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationFieldService {
    @Autowired  // 필드 주입
    private StationRepository stationRepository;

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
