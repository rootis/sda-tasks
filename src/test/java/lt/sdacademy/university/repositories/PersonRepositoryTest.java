package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonRepositoryTest {

    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepository();
    }

    @Test
    void findAll() {
        List<PersonEntity> result = personRepository.findAll();

        assertFalse(result.isEmpty());
    }
}
