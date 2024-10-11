package nextstep.helloworld.core.di;
import org.springframework.stereotype.Service;

@Service
public class StationConstructorService {
    private final StationRepository stationRepository;

    // 생성자 주입
    public StationConstructorService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
    public String sayHi() {
        return stationRepository.sayHi();
    }
}
