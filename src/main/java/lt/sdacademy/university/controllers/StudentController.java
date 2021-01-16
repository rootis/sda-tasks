package lt.sdacademy.university.controllers;

import lt.sdacademy.university.models.dto.Student;
import lt.sdacademy.university.models.dto.StudentSave;
import lt.sdacademy.university.services.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody StudentSave student){
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        studentService.delete(id);

        return true;
    }
/*
    @GetMapping("/{id}")
    public StudentSave getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    */
}
