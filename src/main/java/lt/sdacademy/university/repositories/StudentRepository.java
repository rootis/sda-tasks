package lt.sdacademy.university.repositories;

import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.services.ConnectionService;

public class StudentRepository {

    private final EntityManager em;

    public StudentRepository() {
        em = ConnectionService.getSessionFactory().createEntityManager();
    }

    public List<StudentEntity> findAll() {
        String hqlQuery = "select s from StudentEntity s";
        return em.createQuery(hqlQuery, StudentEntity.class).getResultList();
    }

    public StudentEntity findOne(Long id) {
        return em.find(StudentEntity.class, id);
    }

    public StudentEntity save(StudentEntity student) {
        return persist(student, em::persist);
    }

    public StudentEntity update(StudentEntity student) {
        return persist(student, em::merge);
    }

    public void delete(StudentEntity student) {
        persist(student, em::remove);
    }

    private StudentEntity persist(StudentEntity student, Consumer<StudentEntity> consumer) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            consumer.accept(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return student;
    }
}
