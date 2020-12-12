package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.data.repository.Repository;

public interface StudyProgramRepository extends Repository<StudyProgramEntity, Long> {

    StudyProgramEntity findOneById(Long id);

    List<StudyProgramEntity> findAll();

    StudyProgramEntity save(StudyProgramEntity studyProgram);

    StudyProgramEntity findOneByTitle(String title);
}
