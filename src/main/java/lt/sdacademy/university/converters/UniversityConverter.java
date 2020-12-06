package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.springframework.stereotype.Component;

@Component
public class UniversityConverter extends AbstractConverter<UniversityEntity, University> {

    @Override
    public University convert(UniversityEntity university) {
        return new University(university.getId(), university.getTitle());
    }
}
