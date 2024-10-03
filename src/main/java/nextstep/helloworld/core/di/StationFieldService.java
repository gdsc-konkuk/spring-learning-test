package nextstep.helloworld.core.di;

import org.springframework.stereotype.Service;

@Service
public class StationFieldService {
    private final StationRepository stationRepository;

    public StationFieldService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
