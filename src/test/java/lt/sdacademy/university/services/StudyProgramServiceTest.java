package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyProgramServiceTest {

    private StudyProgramService studyProgramService;

    @BeforeEach
    void setUp() {
        studyProgramService = new StudyProgramService();
    }

    @Test
    void getStudyPrograms() {
        List<StudyProgram> result = studyProgramService.getStudyPrograms();

        assertTrue(result.isEmpty());
    }
}
