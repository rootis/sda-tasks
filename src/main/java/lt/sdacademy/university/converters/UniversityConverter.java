package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityConverter extends AbstractConverter<UniversityEntity, University> {

    private final UniversityRepository universityRepository;

    public UniversityConverter(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University convert(UniversityEntity university) {
        return new University(university.getId(), university.getTitle());
    }

    public UniversityEntity convertToEntity(University university) {
        UniversityEntity result = new UniversityEntity();

        if (university.getId() != null) {
            result = universityRepository.findById(university.getId());
        }

        result.setTitle(university.getTitle());

        return result;
    }
}
