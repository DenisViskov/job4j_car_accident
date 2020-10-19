package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Repository
public class AccidentMem {
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
        accidents.put(first.getId(),first);
        accidents.put(second.getId(),second);
        accidents.put(third.getId(),third);
    }

    public Map<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void addAccident(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentMem that = (AccidentMem) o;
        return Objects.equals(accidents, that.accidents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidents);
    }
}
