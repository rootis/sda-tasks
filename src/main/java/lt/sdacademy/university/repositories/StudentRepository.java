package lt.sdacademy.university.repositories;

import java.util.List;
import javax.persistence.Query;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.StudentEntity;

public class StudentRepository extends AbstractRepository<StudentEntity> {

    @Override
    protected Class<StudentEntity> getEntityClass() {
        return StudentEntity.class;
    }

    public List<StudentEntity> findByPersonLikeName(String nameStart) {
        String hqlQuery = "select s from StudentEntity s where s.person.name LIKE :nameStart";
        Query query = em.createQuery(hqlQuery, StudentEntity.class);
        query.setParameter("nameStart", nameStart);

        return query.getResultList();
    }

    public List<StudentEntity> findByPersonGender(Gender gender) {
        String hqlQuery = "select s from StudentEntity s where s.person.gender=:gender";
        Query query = em.createQuery(hqlQuery, StudentEntity.class);
        query.setParameter("gender", gender);

        return query.getResultList();
    }
}
