package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@? //[1번 문제]
public class HelloDao {
    private JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // [2번 문제]
    public void insert(String name) {
        String SQL = "?";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    // [2번 문제]
    public int countByName(String name) {
        String sql = "?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}