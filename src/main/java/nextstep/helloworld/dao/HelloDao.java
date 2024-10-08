package nextstep.helloworld.dao;

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
        jdbcTemplate.update(SQL, new Object[] {name});
    }

    public int countByNames(String name) {
        String sql = "SELECT COUNT (*) FROM hello WHERE name = ? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}
