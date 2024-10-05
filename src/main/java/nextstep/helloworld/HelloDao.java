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
        String SQL = "insert into hello(id, name) values(NULL,?)";
        jdbcTemplate.update(SQL, new Object[]{name});
    }

    // [2번 문제]
    public int countByName(String name) {
        String sql = "select max(id) from hello where name=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}