package lt.sdacademy.university.repositories;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<PersonEntity, Long> {

    List<PersonEntity> findAll();

    PersonEntity findById(Long id);

    List<PersonEntity> findAllByName(String name);

    void deleteById(Long id);
}
