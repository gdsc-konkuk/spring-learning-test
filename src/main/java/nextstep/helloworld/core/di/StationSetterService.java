package nextstep.helloworld.core.di;

import org.springframework.stereotype.Service;

@Service
public class StationSetterService {
    private final StationRepository stationRepository;

    public StationSetterService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
