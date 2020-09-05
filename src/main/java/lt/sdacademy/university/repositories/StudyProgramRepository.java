package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.data.repository.Repository;

public interface StudyProgramRepository extends Repository<StudyProgramEntity, Long> {

    StudyProgramEntity save(StudyProgramEntity studyProgram);

    StudyProgramEntity findOneByTitle(String title);
}
