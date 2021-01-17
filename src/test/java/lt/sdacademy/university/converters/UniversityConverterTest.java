package lt.sdacademy.university.converters;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lt.sdacademy.university.builders.UniversityEntityBuilder;
import lt.sdacademy.university.models.dto.University;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.repositories.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityConverterTest {

    private UniversityConverter universityConverter;

    @Mock
    private StudyProgramConverter studyProgramConverter;

    @Mock
    private UniversityRepository universityRepository;

    @BeforeEach
    void setUp() {
        universityConverter = new UniversityConverter(studyProgramConverter, universityRepository);
    }

    @Test
    void convert() {
        UniversityEntity universityEntity = UniversityEntityBuilder.init()
            .withId(2L)
            .withCode("TEST_CODE")
            .withTitle("Test title")
            .build();

        University result = universityConverter.convert(universityEntity);

        assertEquals(2L, result.getId());
        assertEquals("TEST_CODE", result.getCode());
        assertEquals("Test title", result.getTitle());
    }

    @Test
    void convert_valueIsNull() {
        UniversityEntity universityEntity = null;

        assertNull(universityConverter.convert(universityEntity));
    }
}
