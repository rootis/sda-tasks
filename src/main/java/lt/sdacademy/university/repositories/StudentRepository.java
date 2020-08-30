package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<StudentEntity, Long> {

    List<StudentEntity> findAll();
}
