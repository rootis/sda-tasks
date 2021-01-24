package lt.sdacademy.movies.converters;

import lt.sdacademy.movies.models.dto.Movie;
import lt.sdacademy.movies.models.entities.MovieEntity;
import lt.sdacademy.movies.repositories.CategoryRepository;
import lt.sdacademy.movies.repositories.MovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends AbstractBiConverter<MovieEntity, Movie> {

    private final CategoryConverter categoryConverter;
    private final MovieRepository movieRepository;

    public MovieConverter(CategoryConverter categoryConverter, MovieRepository movieRepository) {
        this.categoryConverter = categoryConverter;
        this.movieRepository = movieRepository;
    }

    public Movie convert(MovieEntity movie) {
        return new Movie(
            movie.getId(),
            movie.getTitle(),
            categoryConverter.convert(movie.getCategory()),
            movie.getDescription(),
            movie.getYear(),
            movie.getImdbRating());
    }

    @Override
    public MovieEntity convertToEntity(Movie movie) {
        MovieEntity result = movie.getId() == null
            ? new MovieEntity()
            : movieRepository.findById(movie.getId());
        result.setCategory(categoryConverter.convertToEntity(movie.getCategory()));
        result.setDescription(movie.getDescription());
        result.setTitle(movie.getTitle());
        result.setImdbRating(movie.getImdbRating());
        result.setYear(movie.getYear());

        return result;
    }
}
