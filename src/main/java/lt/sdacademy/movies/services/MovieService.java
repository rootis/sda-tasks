package lt.sdacademy.movies.services;

import java.util.List;
import lt.sdacademy.movies.converters.MovieConverter;
import lt.sdacademy.movies.models.dto.Movie;
import lt.sdacademy.movies.models.entities.MovieEntity;
import lt.sdacademy.movies.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieConverter movieConverter;
    private final MovieRepository movieRepository;

    public MovieService(MovieConverter movieConverter, MovieRepository movieRepository) {
        this.movieConverter = movieConverter;
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieConverter.convert(movieRepository.findAll());
    }

    public Movie getMovie(Long movieId) {
        return movieConverter.convert(movieRepository.findById(movieId));
    }

    public Movie save(Movie movie) {
        MovieEntity movieEntity = movieConverter.convertToEntity(movie);
        movieRepository.save(movieEntity);

        return movieConverter.convert(movieEntity);
    }

    public void delete(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
