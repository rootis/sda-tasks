package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.builders.LecturerEntityBuilder;
import lt.sdacademy.university.builders.PersonEntityBuilder;
import lt.sdacademy.university.builders.UniversityEntityBuilder;
import lt.sdacademy.university.builders.UniversityLecturerEntityBuilder;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
@Tag("integration")
class UniversityRepositoryIT {

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    void findAllByLecturerName() {
        UniversityEntity university = UniversityEntityBuilder.init()
            .withCode("TEST")
            .withTitle("Test University")
            .build();
        university.setUniversityLecturers(Arrays.asList(
            UniversityLecturerEntityBuilder.init()
                .withLevel("test_lvl")
                .withSalary(new BigDecimal(1000))
                .withUniversity(university)
                .withLecturer(LecturerEntityBuilder.init()
                    .withPerson(PersonEntityBuilder.init()
                        .withGender(Gender.male)
                        .withName("Lecturer_z")
                        .withSurname("Surname")
                        .build())
                    .build())
                .build()
        ));

        List<UniversityEntity> result = universityRepository.findAllByLecturerName("z");

        assertTrue(result.isEmpty());

        universityRepository.save(university);

        result = universityRepository.findAllByLecturerName("z");

        assertFalse(result.isEmpty());
    }
}
