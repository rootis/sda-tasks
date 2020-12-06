package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UniversityServiceTest {

    @Autowired
    private UniversityService universityService;

    @Test
    void getUniversities() {
        List<University> result = universityService.getUniversities();

        assertFalse(result.isEmpty());
    }

    @Test
    void save() {
        UniversityEntity university = new UniversityEntity();
        university.setCode("TST");
        university.setTitle("Test University");

        university = universityService.save(university);

        assertNotNull(university.getId());
        assertEquals("TST", university.getCode());
        assertEquals("Test University", university.getTitle());
    }

    @Test
    void getUniversitiesByStudyProgramTitle() {
        UniversityEntity university = new UniversityEntity();
        university.setTitle("Test Empty University");
        university.setCode("TEU");
        universityService.save(university);
        university = new UniversityEntity();
        university.setTitle("Test University");
        university.setCode("TU");
        StudyProgramEntity studyProgram = new StudyProgramEntity();
        studyProgram.setTitle("Test Study Program");
        studyProgram.setUniversity(university);
        university.getStudyPrograms().add(studyProgram);
        universityService.save(university);

        List<UniversityEntity> universities = universityService.getUniversitiesByStudyProgramTitle("Test Study Program");

        assertEquals(1, universities.size());
        assertEquals("Test University", universities.get(0).getTitle());
    }

    @Test
    void getUniversitiesByStudyProgramTitle_notExists() {
        List<UniversityEntity> universities = universityService.getUniversitiesByStudyProgramTitle("Test");

        assertTrue(universities.isEmpty());
    }

    @Test
    void delete() {
        List<University> universities = universityService.getUniversities();
        int oldSize = universities.size();

        universityService.delete(universities.get(0).getId());
        universities = universityService.getUniversities();

        assertEquals(oldSize - 1, universities.size());
    }
}
