package lt.sdacademy.university.repositories;

import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.services.ConnectionService;

public class StudyProgramRepository {

    private final EntityManager em;

    public StudyProgramRepository() {
        em = ConnectionService.getSessionFactory().createEntityManager();
    }

    public List<StudyProgramEntity> findAll() {
        String hqlQuery = "select s from StudyProgramEntity s";
        return em.createQuery(hqlQuery, StudyProgramEntity.class).getResultList();
    }

    public StudyProgramEntity findOne(Long id) {
        return em.find(StudyProgramEntity.class, id);
    }

    public StudyProgramEntity save(StudyProgramEntity entity) {
        return persist(entity, em::persist);
    }

    public void delete(StudyProgramEntity entity) {
        persist(entity, em::remove);
    }

    private StudyProgramEntity persist(StudyProgramEntity entity, Consumer<StudyProgramEntity> consumer) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            consumer.accept(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return entity;
    }
}
