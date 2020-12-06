package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.data.repository.Repository;

public interface UniversityRepository extends Repository<UniversityEntity, Long> {

    List<UniversityEntity> findAll();

    UniversityEntity findById(Long id);

    List<UniversityEntity> findAllByStudyProgramsTitle(String title);

    UniversityEntity save(UniversityEntity university);

    void delete(UniversityEntity university);
}
