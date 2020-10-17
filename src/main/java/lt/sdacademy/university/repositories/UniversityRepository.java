package lt.sdacademy.university.repositories;

import java.util.List;
import javax.persistence.Query;
import lt.sdacademy.university.models.entities.UniversityEntity;

public class UniversityRepository extends AbstractRepository<UniversityEntity> {

    @Override
    protected Class<UniversityEntity> getEntityClass() {
        return UniversityEntity.class;
    }

    public List<UniversityEntity> findByLecturerName(String name) {
        String hqlQuery = "select u from UniversityEntity u join u.lecturers as l where l.person.name=:name";
        Query query = em.createQuery(hqlQuery, UniversityEntity.class);
        query.setParameter("name", name);

        return query.getResultList();
    }
}
