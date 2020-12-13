package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAll() {
        List<StudentEntity> result = studentRepository.findAll();

        assertFalse(result.isEmpty());
    }

    @Test
    void findAllByPersonGender() {
        List<StudentEntity> result = studentRepository.findAllByPersonGender(Gender.male);

        assertFalse(result.isEmpty());
    }
}
