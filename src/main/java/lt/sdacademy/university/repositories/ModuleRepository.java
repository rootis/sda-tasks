package lt.sdacademy.university.repositories;

import java.util.Collection;
import java.util.List;
import lt.sdacademy.university.models.entities.ModuleEntity;
import org.springframework.data.repository.Repository;

public interface ModuleRepository extends Repository<ModuleEntity, Long> {

    ModuleEntity findById(Long id);

    List<ModuleEntity> findAll();

    List<ModuleEntity> findAllByTitle(String title);

    List<ModuleEntity> findAllByTitleNot(String title);

    List<ModuleEntity> findAllByTitleIn(Collection<String> titles);

    List<ModuleEntity> findAllByTitleLike(String title);

    List<ModuleEntity> findAllByTitleContains(String title);
}
