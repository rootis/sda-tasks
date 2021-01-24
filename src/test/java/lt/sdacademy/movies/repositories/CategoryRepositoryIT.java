package lt.sdacademy.movies.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;
import lt.sdacademy.movies.builders.CategoryEntityBuilder;
import lt.sdacademy.movies.models.entities.CategoryEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
@Tag("integration")
class CategoryRepositoryIT {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findById() {
        CategoryEntity category = CategoryEntityBuilder.init()
            .withTitle("Test category")
            .build();
        category = categoryRepository.save(category);

        CategoryEntity result = categoryRepository.findById(category.getId());

        assertEquals("Test category", result.getTitle());
    }

    @Test
    void save() {
        CategoryEntity category = CategoryEntityBuilder.init()
            .withTitle("Test category")
            .build();

        category = categoryRepository.save(category);

        assertNotNull(category.getId());
        assertEquals("Test category", category.getTitle());
    }

    @Test
    void deleteById() {
        CategoryEntity category = CategoryEntityBuilder.init()
            .withTitle("Test category")
            .build();
        categoryRepository.save(category);
        int sizeOld = categoryRepository.findAll().size();

        categoryRepository.deleteById(category.getId());

        assertEquals(sizeOld - 1, categoryRepository.findAll().size());
    }
}
