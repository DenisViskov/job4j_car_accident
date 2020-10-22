package accident.repository;

import accident.model.AccidentType;
import accident.model.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 21.10.2020
 */
@Repository
public class AccidentRulesMem implements Store<Rule> {
    Map<Integer, Rule> rules = Map.of(0, Rule.of(0, "article 1"),
            1, Rule.of(1, "article 2"),
            2, Rule.of(2, "article 3"));

    @Override
    public Rule add(Rule some) {
        if (!rules.containsKey(some.getId())) {
            some.setId(rules.size());
            rules.put(some.getId(), some);
        }
        return some;
    }

    @Override
    public List<Rule> findAll() {
        return rules.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void update(Rule some) {
        rules.put(some.getId(), some);
    }
}
