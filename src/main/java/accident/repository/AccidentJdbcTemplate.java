package accident.repository;

import accident.model.Accident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 23.10.2020
 */
//@Repository
public class AccidentJdbcTemplate implements Store<Accident> {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Accident add(Accident some) {
        jdbc.update("insert into accident (name) values (?)",
                some.getName());
        return some;
    }

    @Override
    public List<Accident> findAll() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    @Override
    public void update(Accident some) {
        jdbc.update("update accident set name = (?) where id = (?)",
                some.getName(),
                some.getId());
    }
}
