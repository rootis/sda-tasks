package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends Repository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s")
    List<StudentEntity> findAll();

    @Query("select s from StudentEntity s where s.person.name LIKE %:fragment%")
    List<StudentEntity> findAllByPersonName(@Param("fragment") String fragment);

    @Query("SELECT s FROM StudentEntity s where s.person.gender = :gender")
    List<StudentEntity> findAllByPersonGender(@Param("gender") Gender gender);
}
