package nextstep.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
  private final JdbcTemplate jdbcTemplate;

  public HelloDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void insert(String name) {
    String SQL = "INSERT INTO hello (name) VALUES (?)";
    jdbcTemplate.update(SQL, name);
  }

  public int countByName(String name) {
    String sql = "SELECT count(*) FROM hello WHERE name = ?";
    return jdbcTemplate.queryForObject(sql, Integer.class, name);
  }
}
