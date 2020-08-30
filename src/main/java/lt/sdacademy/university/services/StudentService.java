package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }
}
