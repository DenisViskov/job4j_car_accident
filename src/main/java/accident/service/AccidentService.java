package accident.service;

import accident.model.Accident;
import accident.repository.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Service
public class AccidentService implements RepositoryService<Accident> {
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
        store.add(some);
    }

    @Override
    public void update(Accident some) {
        store.update(some);
    }
}
