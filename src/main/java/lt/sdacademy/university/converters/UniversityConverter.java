package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityConverter extends AbstractConverter<UniversityEntity, University> {

    private final StudyProgramConverter studyProgramConverter;
    private final UniversityRepository universityRepository;

    public UniversityConverter(StudyProgramConverter studyProgramConverter, UniversityRepository universityRepository) {
        this.studyProgramConverter = studyProgramConverter;
        this.universityRepository = universityRepository;
    }

    @Override
    public University convert(UniversityEntity university) {
        return new University(
            university.getId(),
            university.getCode(),
            university.getTitle(),
            university.getStudyPrograms().size(),
            studyProgramConverter.convert(university.getStudyPrograms())
        );
    }

    public UniversityEntity convertToEntity(University university) {
        UniversityEntity result = new UniversityEntity();

        if (university.getId() != null) {
            result = universityRepository.findById(university.getId());
        }

        result.setCode(university.getCode());
        result.setTitle(university.getTitle());
        result.setStudyPrograms(studyProgramConverter.convertToEntity(university.getStudyPrograms()));

        for (StudyProgramEntity studyProgram : result.getStudyPrograms()) {
            studyProgram.setUniversity(result);
        }

        return result;
    }
}
