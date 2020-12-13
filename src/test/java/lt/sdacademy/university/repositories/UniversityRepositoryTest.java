package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UniversityRepositoryTest {

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    void findAllByLecturerName() {
        List<UniversityEntity> result = universityRepository.findAllByLecturerName("t");

        assertFalse(result.isEmpty());
    }
}
