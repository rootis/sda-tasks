package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getStudents() {
        List<StudentEntity> result = studentService.getStudents();

        assertFalse(result.isEmpty());
        result.forEach(s -> assertNotNull(s.getPerson()));
    }

    @Test
    void getStudentsByGender() {
        List<StudentEntity> result = studentService.getStudentsByGender(Gender.male);

        result.forEach(s -> assertEquals(Gender.male, s.getPerson().getGender()));
    }
}
