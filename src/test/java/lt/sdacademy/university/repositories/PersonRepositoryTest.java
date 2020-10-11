package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.List;
import lt.sdacademy.university.models.Gender;
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

    @Test
    void findOne() {
        PersonEntity result = personRepository.findOne(1L);

        assertNotNull(result);
    }

    @Test
    void save() {
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);

        person = personRepository.save(person);

        assertNotNull(person.getId());
        personRepository.delete(person);
    }

    @Test
    void delete() {
        Integer oldSize = personRepository.findAll().size();
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);

        person = personRepository.save(person);
        assertEquals(oldSize + 1, personRepository.findAll().size());

        personRepository.delete(person);
        assertEquals(oldSize, personRepository.findAll().size());
    }
}
