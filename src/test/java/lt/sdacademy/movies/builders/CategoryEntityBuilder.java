package lt.sdacademy.movies.builders;

import java.util.HashSet;
import java.util.Set;
import lt.sdacademy.movies.models.entities.CategoryEntity;
import lt.sdacademy.movies.models.entities.MovieEntity;

public final class CategoryEntityBuilder {

    private Long id;
    private String title;
    private Set<MovieEntity> movies = new HashSet<>();

    private CategoryEntityBuilder() {
    }

    public static CategoryEntityBuilder init() {
        return new CategoryEntityBuilder();
    }

    public CategoryEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CategoryEntityBuilder withMovies(Set<MovieEntity> movies) {
        this.movies = movies;
        return this;
    }

    public CategoryEntity build() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id);
        categoryEntity.setTitle(title);
        categoryEntity.setMovies(movies);
        return categoryEntity;
    }
}
