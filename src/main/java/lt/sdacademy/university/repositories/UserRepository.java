package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity findById(Long id);

    UserEntity save(UserEntity userEntity);

    boolean existsByEmail(String email);
}
