package lt.sdacademy.movies.repositories;

import java.util.List;
import lt.sdacademy.movies.models.entities.CategoryEntity;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<CategoryEntity, Long> {

    CategoryEntity findById(Long id);

    List<CategoryEntity> findAll();

    void deleteById(Long id);

    CategoryEntity save(CategoryEntity category);
}
