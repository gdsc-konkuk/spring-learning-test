package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HelloDao {
    private JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insert(String name) {
        String SQL = "INSERT INTO hello (name) VALUES (?)";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    @Transactional
    public int countByName(String name) {
        String sql = "SELECT COUNT(*) FROM hello WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}