package lt.sdacademy.movies.converters;

import lt.sdacademy.movies.models.dto.Category;
import lt.sdacademy.movies.models.entities.CategoryEntity;
import lt.sdacademy.movies.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractBiConverter<CategoryEntity, Category> {

    private final CategoryRepository categoryRepository;

    public CategoryConverter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category convert(CategoryEntity obj) {
        return null;
    }

    @Override
    public CategoryEntity convertToEntity(Category category) {
        CategoryEntity result = category.getId() == null
            ? new CategoryEntity()
            : categoryRepository.findById(category.getId());
        category.setTitle(category.getTitle());

        return result;
    }
}
