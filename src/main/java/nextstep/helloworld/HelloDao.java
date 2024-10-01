package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
    private JdbcTemplate jdbcTemplate;

    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // [2번 문제]
    public void insert(String name) {
        String SQL = "insert into hello (name) values (?)";
        jdbcTemplate.update(SQL, name);
    }

    // [2번 문제]
    public int countByName(String name) {
        String sql = "select count(*) from hello where name = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}
