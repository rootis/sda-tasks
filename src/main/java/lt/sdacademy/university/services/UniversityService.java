package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.PersonRepository;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<UniversityEntity> getUniversities() {
        return universityRepository.findAll();
    }

    public List<UniversityEntity> getUniversitiesByStudyProgramTitle(String studyProgramTitle) {
        return universityRepository.findAllByStudyProgramsTitle(studyProgramTitle);
    }

    public UniversityEntity save(UniversityEntity university) {
        return universityRepository.save(university);
    }

    public void delete(UniversityEntity university) {
        universityRepository.delete(university);
    }
}
