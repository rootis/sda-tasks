package lt.sdacademy.university.controllers;

import java.util.List;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.services.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getUniversities() {
        return universityService.getUniversities();
    }

    @GetMapping("/{universityId}")
    public University getUniversity(@PathVariable Long universityId) {
        return universityService.getUniversity(universityId);
    }

    @PostMapping
    public University save(@RequestBody University university) {
        return universityService.save(university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
