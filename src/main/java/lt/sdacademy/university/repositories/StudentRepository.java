package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends Repository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s")
    List<StudentEntity> findAll();

    //    get list of students by study type
    @Query("from StudentEntity s where s.studyType=:studyType")
    List<StudentEntity> findAllByStudyType(StudyType studyType);

    @Query("from StudentEntity s " +
        "join s.studyProgram.modules m " +
        "where s.studyType=:studyType and m.title=:title")
    List<StudentEntity> findAllByModuleTitle(StudyType studyType, String title);

    StudentEntity findById(Long id);

    StudentEntity save(StudentEntity convert);

    void deleteById(Long id);

    @Query("SELECT s FROM StudentEntity s where s.person.gender = :gender")
    List<StudentEntity> findAllByPersonGender(@Param("gender") Gender gender);

    //    create findAllByPersonName and verify it
    @Query("SELECT s from StudentEntity s where s.person.name = :name")
    List<StudentEntity> findAllByPersonName(@Param("name") String name);

    //    use name fragment (with LIKE) and ignore case sensitive
    @Query("select s from StudentEntity s where s.person.name LIKE %:fragment%")
    List<StudentEntity> findAllByNameLike(@Param("fragment") String fragment);

    StudentEntity getOne(Long id);
}
