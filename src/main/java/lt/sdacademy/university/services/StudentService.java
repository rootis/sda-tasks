package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.StudentConverter;
import lt.sdacademy.university.converters.StudentSaveConverter;
import lt.sdacademy.university.models.dto.Student;
import lt.sdacademy.university.models.dto.StudentSave;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.repositories.PersonRepository;
import lt.sdacademy.university.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    private final StudentSaveConverter studentSaveConverter;

    public StudentService(PersonRepository personRepository, StudentRepository studentRepository, StudentConverter studentConverter,
        StudentSaveConverter studentSaveConverter) {
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
        this.studentSaveConverter = studentSaveConverter;
    }

    public List<Student> getStudents() {
        return studentConverter.convert(studentRepository.findAll());
    }

    public Student save(StudentSave student) {
        StudentEntity studentEntity = studentSaveConverter.convertToEntity(student);
        StudentEntity result = studentRepository.save(studentEntity);
        return studentConverter.convert(result);
    }

    public void delete(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id);
        Long personId = studentEntity.getPerson().getId();
        studentRepository.deleteById(id);
        personRepository.deleteById(personId);
    }
/*
    public Student getStudentById(Long id) {
        return studentConverter.convert(studentRepository.findById(id));
    }

    */
}
