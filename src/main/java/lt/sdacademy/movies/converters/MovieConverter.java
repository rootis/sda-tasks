package lt.sdacademy.movies.converters;

import lt.sdacademy.movies.models.dto.Movie;
import lt.sdacademy.movies.models.entities.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends AbstractBiConverter<MovieEntity, Movie> {

    @Override
    public Movie convert(MovieEntity obj) {
        return null;
    }

    @Override
    public MovieEntity convertToEntity(Movie obj) {
        return null;
    }
}
