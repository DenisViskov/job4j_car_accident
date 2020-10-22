package accident.service;

import accident.model.Accident;
import accident.model.AccidentType;
import accident.model.Rule;
import accident.repository.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 19.10.2020
 */
@Service
public class AccidentService implements RepositoryService<Accident, AccidentType, Rule> {

    private final Store storeAccident;
    private final Store storeTypes;
    private final Store storeRules;

    @Autowired
    public AccidentService(@Qualifier("accidentMem") Store storeAccident,
                           @Qualifier("accidentTypesMem") Store storeTypes,
                           @Qualifier("accidentRulesMem") Store storeRules) {
        this.storeAccident = storeAccident;
        this.storeTypes = storeTypes;
        this.storeRules = storeRules;
    }

    @Override
    public Optional<Accident> findByIdAccident(int id) {
        List<Accident> accidents = storeAccident.findAll();
        return accidents.stream()
                .filter(accident -> accident.getId() == id)
                .findFirst();
    }

    @Override
    public List<Accident> getAllAccidents() {
        return storeAccident.findAll();
    }

    @Override
    public void saveAccident(Accident some, String[] ids) {
        some.setType(findByIdType(some.getType()
                .getId())
                .get());
        Arrays.stream(ids)
                .forEach(id -> some.addRule(findByIdRule(Integer.valueOf(id))
                        .get()));
        storeAccident.add(some);
    }

    @Override
    public void updateAccident(Accident some) {
        storeAccident.update(some);
    }

    @Override
    public Optional<AccidentType> findByIdType(int id) {
        List<AccidentType> types = storeTypes.findAll();
        return types.stream()
                .filter(type -> type.getId() == id)
                .findFirst();
    }

    @Override
    public List<AccidentType> getAllTypes() {
        return storeTypes.findAll();
    }

    @Override
    public void saveType(AccidentType some) {
        storeTypes.add(some);
    }

    @Override
    public void updateType(AccidentType some) {
        storeTypes.update(some);
    }

    @Override
    public Optional<Rule> findByIdRule(int id) {
        List<Rule> rules = storeRules.findAll();
        return rules.stream()
                .filter(rule -> rule.getId() == id)
                .findFirst();
    }

    @Override
    public List<Rule> getAllRules() {
        return storeRules.findAll();
    }

    @Override
    public void saveRule(Rule some) {
        storeRules.add(some);
    }

    @Override
    public void updateRule(Rule some) {
        storeRules.update(some);
    }
}
