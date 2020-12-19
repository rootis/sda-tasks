package lt.sdacademy.university.validators;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.exceptions.ValidationException;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UniversityValidatorTest {

    @Mock
    UniversityRepository universityRepository;

    private UniversityValidator universityValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        universityValidator = new UniversityValidator(universityRepository);
    }

    @Test
    void validate() {
        University university = new University(null, "TEST", null, null, null);

        universityValidator.validate(university);
    }

    @Test
    void validate_universityExists() {
        when(universityRepository.existsByCode("TEST")).thenReturn(true);
        University university = new University(null, "TEST", null, null, null);

        assertThrows(ValidationException.class, () -> universityValidator.validate(university));
    }

    @Test
    void validate_universityExistsOnUpdate() {
        when(universityRepository.existsByCodeAndIdNot("TEST", 2L)).thenReturn(true);
        University university = new University(2L, "TEST", null, null, null);

        assertThrows(ValidationException.class, () -> universityValidator.validate(university));
    }

    @Test
    void validate_codeWithSpaces() {
        University university = new University(2L, "  ", null, null, null);

        assertThrows(ValidationException.class, () -> universityValidator.validate(university));
    }

    @Test
    void validate_codeStartsWithNumber() {
        // TODO: write
    }
}
