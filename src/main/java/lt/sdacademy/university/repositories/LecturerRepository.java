package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.LecturerEntity;
import org.springframework.data.repository.Repository;

public interface LecturerRepository extends Repository<LecturerEntity, Long> {

    LecturerEntity save(LecturerEntity lecturer);
}
