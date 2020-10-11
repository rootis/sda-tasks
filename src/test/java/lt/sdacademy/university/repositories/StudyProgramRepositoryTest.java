package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyProgramRepositoryTest {

    private StudyProgramRepository studyProgramRepository;

    @BeforeEach
    void setUp() {
        studyProgramRepository = new StudyProgramRepository();
    }

    @Test
    void findOne() {
        StudyProgramEntity result = studyProgramRepository.findOne(1L);

        assertFalse(result.getStudents().isEmpty());
    }

    @Test
    void save() {
        Integer oldSize = studyProgramRepository.findAll().size();
        StudyProgramEntity studyProgram = new StudyProgramEntity();
        studyProgram.setUniversityId(1L);
        studyProgram.setTitle("Test Study Program");
        StudentEntity student = new StudentEntity();
        student.setDateStarted(LocalDate.now());
        student.setStudyType(StudyType.dienines);
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);
        student.setPerson(person);
        studyProgram.getStudents().add(student);

        StudyProgramEntity result = studyProgramRepository.save(studyProgram);

        assertNotNull(result.getId());
        assertEquals(oldSize + 1, studyProgramRepository.findAll().size());
        assertEquals(1, studyProgramRepository.findOne(result.getId()).getStudents().size());
        studyProgramRepository.delete(result);
        assertEquals(oldSize, studyProgramRepository.findAll().size());
    }
}
