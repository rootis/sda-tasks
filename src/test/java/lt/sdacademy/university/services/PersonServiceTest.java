package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
    }

    @Test
    void getPeople() {
        List<PersonEntity> people = personService.getPeople();

        assertFalse(people.isEmpty());
    }
}
