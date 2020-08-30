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
        this.entityManagerFactory = ConnectionService.getSessionFactory();
    }

    public void save(PersonEntity person) {
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
    }

    public void update(PersonEntity person) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
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

    public void delete(List<PersonEntity> persons) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            this.delete(em, persons);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(EntityManager em, List<PersonEntity> persons) {
        persons.forEach(em::remove);
    }

    public PersonEntity findOne(Integer id) {
        return entityManagerFactory.createEntityManager().find(PersonEntity.class, id);
    }

    public List<PersonEntity> findAll() {
        return entityManagerFactory.createEntityManager().createQuery("from PersonEntity", PersonEntity.class).getResultList();
    }
}
