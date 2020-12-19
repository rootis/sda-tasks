package lt.sdacademy.university.validators;

import java.util.HashMap;
import java.util.Map;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.exceptions.ValidationException;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityValidator {

    private final UniversityRepository universityRepository;

    public UniversityValidator(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void validate(University university) {
        Map<String, String> errors = new HashMap<>();

        validateCode(university, errors);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateCode(University university, Map<String, String> errors) {
        if (university.getId() == null) {
            if (universityRepository.existsByCode(university.getCode())) {
                errors.put("code", "such university already exists");
            }
        } else if (universityRepository.existsByCodeAndIdNot(university.getCode(), university.getId())) {
            errors.put("code", "such university already exists");
        }
    }
}
