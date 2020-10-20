package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Repository
public class AccidentMem implements Store<Accident> {
    private final Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        Accident first = new Accident(0,
                "Destroyed two cars",
                "There are people injured",
                "5th avenue");
        Accident second = new Accident(1,
                "Destroyed three cars",
                "There are people injured",
                "8th avenue");
        Accident third = new Accident(2,
                "Destroyed three cars",
                "There are people injured",
                "10th avenue");
        accidents.put(first.getId(), first);
        accidents.put(second.getId(), second);
        accidents.put(third.getId(), third);
    }

    @Override
    public void update(Accident some) {
        if (accidents.containsKey(some.getId())) {
            accidents.replace(some.getId(),some);
        }
    }

    @Override
    public Accident add(Accident some) {
        some.setId(accidents.size());
        accidents.put(some.getId(), some);
        return some;
    }

    @Override
    public List<Accident> findAll() {
        return accidents.values()
                .stream()
                .collect(Collectors.toList());
    }
}
