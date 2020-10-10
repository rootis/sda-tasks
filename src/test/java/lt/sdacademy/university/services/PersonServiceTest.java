package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        personService = new PersonService();
    }

    @Test
    void save() {
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);

        PersonEntity result = personService.save(person);

        assertNotNull(person.getId());
        personService.delete(result);
    }

    @Test
    void getPeople() {
        List<PersonEntity> people = personService.getPeople();

        assertFalse(people.isEmpty());
        assertEquals(14, people.size());
    }
}
