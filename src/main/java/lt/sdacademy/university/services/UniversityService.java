package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.converters.UniversityConverter;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityConverter universityConverter;

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityConverter universityConverter, UniversityRepository universityRepository) {
        this.universityConverter = universityConverter;
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities(Integer page, Integer size) {
        return universityConverter.convert(universityRepository.findAll(PageRequest.of(page, size)));
    }

    public List<University> getUniversities() {
        return universityConverter.convert(universityRepository.findAll());
    }

    public University getUniversity(Long universityId) {
        return universityConverter.convert(universityRepository.findById(universityId));
    }

    public List<UniversityEntity> getUniversitiesByStudyProgramTitle(String studyProgramTitle) {
        return universityRepository.findAllByStudyProgramsTitle(studyProgramTitle);
    }

    public UniversityEntity save(UniversityEntity university) {
        return universityRepository.save(university);
    }

    public University save(University university) {
        UniversityEntity result = universityRepository.save(universityConverter.convertToEntity(university));

        return universityConverter.convert(result);
    }

    public void delete(Long id) {
        universityRepository.deleteById(id);
    }
}
