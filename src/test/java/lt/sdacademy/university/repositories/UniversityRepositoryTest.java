package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniversityRepositoryTest {

    private UniversityRepository universityRepository;

    @BeforeEach
    void setUp() {
        universityRepository = new UniversityRepository();
    }

    @Test
    void findByLecturerName() {
        List<UniversityEntity> result = universityRepository.findByLecturerName("Rutenis");

        assertFalse(result.isEmpty());
    }
}
