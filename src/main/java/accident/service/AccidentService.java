package accident.service;

import accident.model.Accident;
import accident.model.AccidentType;
import accident.repository.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Service
public class AccidentService implements RepositoryService<Accident, AccidentType> {
    @Autowired
    private final Store store;

    public AccidentService(Store store) {
        this.store = store;
    }

    @Override
    public Optional<Accident> findById(int id) {
        List<Accident> accidents = store.findAll();
        return accidents.stream()
                .filter(accident -> accident.getId() == id)
                .findFirst();
    }

    @Override
    public List<Accident> getAll() {
        return store.findAll();
    }

    @Override
    public void save(Accident some) {
        List<AccidentType> accidentTypes = getAccidentTypes();
        some.setType(accidentTypes.get(some.getType().getId()));
        store.add(some);
    }

    @Override
    public void update(Accident some) {
        store.update(some);
    }

    @Override
    public List<AccidentType> getAccidentTypes() {
        return store.getAccidentTypes();
    }
}
