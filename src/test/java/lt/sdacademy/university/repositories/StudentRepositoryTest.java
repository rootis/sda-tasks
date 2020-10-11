package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    void findAll() {
        List<StudentEntity> result = studentRepository.findAll();

        assertFalse(result.isEmpty());
    }

    @Test
    void findOne() {
        StudentEntity result = studentRepository.findOne(1L);

        assertNotNull(result);
        assertNotNull(result.getStudyProgram());
    }
}
