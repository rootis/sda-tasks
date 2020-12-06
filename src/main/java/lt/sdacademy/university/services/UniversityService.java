package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityConverter universityConverter;

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityConverter universityConverter, UniversityRepository universityRepository) {
        this.universityConverter = universityConverter;
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        List<UniversityEntity> universities = universityRepository.findAll();

        return universityConverter.convert(universities);
    }

    public List<UniversityEntity> getUniversitiesByStudyProgramTitle(String studyProgramTitle) {
        return universityRepository.findAllByStudyProgramsTitle(studyProgramTitle);
    }

    public UniversityEntity save(UniversityEntity university) {
        return universityRepository.save(university);
    }

    public void delete(University university) {
        UniversityEntity universityEntity = universityConverter.convertToEntity(university);
        universityRepository.delete(universityEntity);
    }
}
