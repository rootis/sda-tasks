package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.SQLException;
import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonRepositoryTest {

    private PersonRepository personRepository;

    @BeforeEach
    void setUp() throws SQLException {
        personRepository = new PersonRepository();
    }

    @Test
    void findAll() {
        List<PersonEntity> result = personRepository.findAll();

        assertFalse(result.isEmpty());
    }
}
