package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import org.springframework.stereotype.Component;

@Component
public class StudyProgramConverter extends AbstractConverter<StudyProgramEntity, StudyProgram> {

    @Override
    public StudyProgram convert(StudyProgramEntity studyProgram) {
        return new StudyProgram(
            studyProgram.getId(),
            studyProgram.getTitle(),
            studyProgram.getUniversity().getCode(),
            studyProgram.getModules().size()
        );
    }
}
