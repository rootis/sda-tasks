package lt.sdacademy.university.services;

import lt.sdacademy.university.models.dto.StudyProgram;
import org.springframework.stereotype.Service;

@Service
public class StudyProgramService {

    public StudyProgram getStudyProgram() {
        return new StudyProgram(2L, "Spring", null);
    }
}
