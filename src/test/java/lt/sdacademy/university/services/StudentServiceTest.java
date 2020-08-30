package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import javax.transaction.Transactional;
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
    }
}
