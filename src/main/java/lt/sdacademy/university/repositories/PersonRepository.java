package lt.sdacademy.university.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.services.ConnectionService;

public class PersonRepository {

    private final EntityManagerFactory entityManagerFactory;

    public PersonRepository() {
        entityManagerFactory = ConnectionService.getSessionFactory();
    }

    public List<PersonEntity> findAll() {
        String hqlQuery = "select p from PersonEntity p";
        return entityManagerFactory.createEntityManager().createQuery(hqlQuery, PersonEntity.class).getResultList();
    }

    public PersonEntity findOne(Long id) {
        return entityManagerFactory.createEntityManager().find(PersonEntity.class, id);
    }

    public PersonEntity save(PersonEntity person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return person;
    }

    public PersonEntity update(PersonEntity person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return person;
    }

    public void delete(PersonEntity person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
