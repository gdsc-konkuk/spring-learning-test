package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class HelloDao {
    private JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String name) {
        String SQL = "INSERT INTO hello (name) VALUES (?)";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    public int countByName(String name) {
        String sql = "SELECT COUNT(1) FROM hello WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}