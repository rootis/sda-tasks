package lt.sdacademy.movies.repositories;

import java.util.List;
import lt.sdacademy.movies.models.entities.MovieEntity;
import org.springframework.data.repository.Repository;

public interface MovieRepository extends Repository<MovieEntity, Long> {

    MovieEntity findById(Long id);

    List<MovieEntity> findAll();

    void deleteById(Long id);

    MovieEntity save(MovieEntity movie);
}
