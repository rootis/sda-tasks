package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.services.ConnectionService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonRepositoryTest {

    private Savepoint sp;
    private PersonRepository personRepository;

    @BeforeAll
    static void init() throws SQLException {
        ConnectionService.getConnection().setAutoCommit(false);
    }

    @BeforeEach
    void setUp() throws SQLException {
        sp = ConnectionService.getConnection().setSavepoint();
        personRepository = new PersonRepository();
    }

    @AfterEach
    void tearDown() throws SQLException {
        ConnectionService.getConnection().rollback(sp);
    }

    @AfterAll
    static void rollback() throws SQLException {
        ConnectionService.getConnection().rollback();
    }

    @Test
    void findAll() {
        List<PersonEntity> result = personRepository.findAll();

        assertFalse(result.isEmpty());
    }

    @Test
    void save() {
        Integer oldSize = personRepository.findAll().size();
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);

        personRepository.save(person);

        assertEquals(oldSize + 1, personRepository.findAll().size());
    }

    @Test
    void update() {
        PersonEntity person = personRepository.findOne(1L);
        person.setName("Modified Name");
        person.setSurname("Modified Surname");

        personRepository.update(person);
        PersonEntity result = personRepository.findOne(1L);

        assertEquals("Modified Name", result.getName());
        assertEquals("Modified Surname", result.getSurname());
    }

    @Test
    void update_idIsNull() {
        PersonEntity person = personRepository.findOne(1L);
        person.setName("Modified Name");
        person.setSurname("Modified Surname");
        person.setId(null);

        assertThrows(InvalidParameterException.class, () -> personRepository.update(person));
    }

    @Test
    void delete() {
        PersonEntity person = new PersonEntity();
        person.setName("Test Name");
        person.setSurname("Test Surname");
        person.setGender(Gender.male);
        personRepository.save(person);
        List<PersonEntity> people = personRepository.findAll();
        Integer oldSize = people.size();

        personRepository.delete(people.get(oldSize - 1).getId());

        assertEquals(oldSize - 1, personRepository.findAll().size());
    }
}
