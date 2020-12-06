package lt.sdacademy.university.controllers;

import java.util.List;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.services.UniversityService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getUniversities() {
        return universityService.getUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversity(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteUniversity(@PathVariable Long id) {
        return false;
    }
}
