package lt.sdacademy.university.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import lt.sdacademy.university.AbstractIntegration;
import lt.sdacademy.university.builders.UniversityEntityBuilder;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import lt.sdacademy.university.services.SecurityService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("integration")
class UniversityControllerIT extends AbstractIntegration {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    void getAll() throws Exception {
        List<UniversityEntity> existingUniversities = universityRepository.findAll();
        UniversityEntity university = UniversityEntityBuilder.init()
            .withCode("TEST")
            .withTitle("Test University")
            .build();
        universityRepository.save(university);

        List<University> result = sendGet("/api/universities", new TypeReference<List<University>>() {
        });

        assertEquals(existingUniversities.size() + 1, result.size());
    }

    @Test
    void getUniversity() throws Exception {
        UniversityEntity university = UniversityEntityBuilder.init()
            .withCode("TEST")
            .withTitle("Test University")
            .build();
        universityRepository.save(university);

        University result = sendGet("/api/universities/" + university.getId(), new TypeReference<University>() {
        }, securityService.generateToken("rutenis.turcinas@gmail.com"));

        assertEquals(university.getId(), result.getId());
        assertEquals("TEST", result.getCode());
        assertEquals("Test University", result.getTitle());
    }
}
