package accident.repository;

import accident.model.AccidentType;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 21.10.2020
 */
@Repository
public class AccidentTypesMem implements Store<AccidentType> {
    Map<Integer, AccidentType> types = Map.of(0, AccidentType.of(0, "Two cars"),
            1, AccidentType.of(1, "Car and human"),
            2, AccidentType.of(2, "Car and bike"));

    @Override
    public AccidentType add(AccidentType some) {
        if (!types.containsKey(some.getId())) {
            some.setId(types.size());
            types.put(some.getId(), some);
        }
        return some;
    }

    @Override
    public List<AccidentType> findAll() {
        return types.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(AccidentType some) {
        types.put(some.getId(), some);
    }
}
