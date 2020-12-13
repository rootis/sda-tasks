package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UniversityRepository extends Repository<UniversityEntity, Long> {

    List<UniversityEntity> findAll();

    @Query("SELECT u FROM UniversityEntity u join u.universityLecturers ul join ul.lecturer l join l.person p WHERE p.name LIKE %:lecturerName%")
    List<UniversityEntity> findAllByLecturerName(@Param("lecturerName") String lecturerName);

    UniversityEntity findById(Long id);

    List<UniversityEntity> findAllByStudyProgramsTitle(String title);

    UniversityEntity save(UniversityEntity university);

    void deleteById(Long id);
}
