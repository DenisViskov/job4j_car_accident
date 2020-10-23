package accident.repository;

import accident.model.Accident;
import accident.model.AccidentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 23.10.2020
 */
@Repository
public class AccidentHibernate implements Store<AccidentEntity> {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public AccidentEntity add(AccidentEntity some) {
        try (Session session = sf.openSession()) {
            session.save(some);
            return some;
        }
    }

    @Override
    public List<AccidentEntity> findAll() {
        try (Session session = sf.openSession()) {
            return session.createQuery("from AccidentEntity")
                    .list();
        }
    }

    @Override
    public void update(AccidentEntity some) {
        try (Session session = sf.openSession()) {
            session.update(some);
        }
    }
}
