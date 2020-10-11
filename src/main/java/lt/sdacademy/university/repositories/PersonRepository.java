package lt.sdacademy.university.repositories;

import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.services.ConnectionService;

public class PersonRepository {

    private final EntityManager em;

    public PersonRepository() {
        em = ConnectionService.getSessionFactory().createEntityManager();
    }

    public List<PersonEntity> findAll() {
        String hqlQuery = "select p from PersonEntity p";
        return em.createQuery(hqlQuery, PersonEntity.class).getResultList();
    }

    public PersonEntity findOne(Long id) {
        return em.find(PersonEntity.class, id);
    }

    public PersonEntity save(PersonEntity person) {
        return persist(person, em::persist);
    }

    public PersonEntity update(PersonEntity person) {
        return persist(person, em::merge);
    }

    public void delete(PersonEntity person) {
        persist(person, em::remove);
    }

    private PersonEntity persist(PersonEntity person, Consumer<PersonEntity> consumer) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            consumer.accept(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return person;
    }
}
