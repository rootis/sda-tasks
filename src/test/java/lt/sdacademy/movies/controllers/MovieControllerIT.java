package lt.sdacademy.movies.controllers;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import lt.sdacademy.movies.AbstractIntegration;
import lt.sdacademy.movies.models.dto.Category;
import lt.sdacademy.movies.models.dto.Movie;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration")
class MovieControllerIT extends AbstractIntegration {

    @Test
    void getMovie() {
    }

    @Test
    void save() throws Exception {
        Movie movie = new Movie(
            null,
            "Test Movie",
            new Category(
                null,
                "Test Category"
            ),
            "Description",
            2020,
            new BigDecimal("7.4")
        );

        Movie result = sendPost("/api/movies", movie, new TypeReference<Movie>() {
        });

        assertNotNull(result.getId());
        assertNotNull(result.getCategory().getId());
    }

    @Test
    void delete() {
    }
}
