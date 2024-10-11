package nextstep.helloworld.core.scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineService {
    private final LineDao lineDao;

    @Autowired
    public LineService(LineDao lineDao) {
        this.lineDao = lineDao;
    }
}
