package lt.sdacademy.university.repositories;

import java.util.List;
import javax.persistence.EntityManagerFactory;
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
}
