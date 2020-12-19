package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.springframework.stereotype.Component;

@Component
public class StudyProgramConverter extends AbstractBiConverter<StudyProgramEntity, StudyProgram> {

    private final ModuleConverter moduleConverter;
    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramConverter(ModuleConverter moduleConverter, StudyProgramRepository studyProgramRepository) {
        this.moduleConverter = moduleConverter;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public StudyProgram convert(StudyProgramEntity studyProgram) {
        return new StudyProgram(
            studyProgram.getId(),
            studyProgram.getTitle(),
            studyProgram.getUniversity().getCode(),
            moduleConverter.convert(studyProgram.getModules())
        );
    }

    public StudyProgramEntity convertToEntity(StudyProgram studyProgram) {
        StudyProgramEntity result = new StudyProgramEntity();

        if (studyProgram.getId() != null) {
            result = studyProgramRepository.findById(studyProgram.getId());
        }

        result.setTitle(studyProgram.getTitle());
        result.setModules(moduleConverter.convertToEntity(studyProgram.getModules()));

        return result;
    }
}
