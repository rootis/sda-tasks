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
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
@Tag("integration")
class UniversityServiceIT {

    @Autowired
    private StudyProgramRepository studyProgramRepository;

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
    void save_studyProgramSaveDelete() {
        UniversityEntity university = new UniversityEntity();
        university.setCode("TST");
        university.setTitle("Test University");
        StudyProgramEntity studyProgram = new StudyProgramEntity();
        studyProgram.setTitle("Test Study Program");
        studyProgram.setUniversity(university);
        university.getStudyPrograms().add(studyProgram);

        university = universityService.save(university);

        assertNotNull(university.getId());
        assertNotNull(university.getStudyPrograms().get(0).getId());

        university.getStudyPrograms().remove(studyProgram);

        Integer studyProgramAmount = studyProgramRepository.findAll().size();
        university = universityService.save(university);

        assertTrue(university.getStudyPrograms().isEmpty());
        assertEquals(studyProgramAmount - 1, studyProgramRepository.findAll().size());
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
