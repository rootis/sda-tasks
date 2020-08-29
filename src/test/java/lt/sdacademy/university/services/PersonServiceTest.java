package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    private Savepoint sp;
    private PersonService personService;

    @BeforeAll
    static void init() throws SQLException {
        ConnectionService.getConnection().setAutoCommit(false);
    }

    @BeforeEach
    void setUp() throws SQLException {
        sp = ConnectionService.getConnection().setSavepoint();
        personService = new PersonService();
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
    void getPersons() {
        List<PersonEntity> people = personService.getPersons();

        assertFalse(people.isEmpty());
    }

    @Test
    void getPerson() {
        PersonEntity result = personService.getPerson(1L);

        assertNotNull(result);
    }

    @Test
    void getPersonBySurname() {
        PersonEntity result = personService.getPersonBySurname("Turcinas");

        assertNotNull(result);
    }

    @Test
    void getPersonBySurname_notExists() {
        PersonEntity result = personService.getPersonBySurname("SDA");

        assertNull(result);
    }

    @Test
    void getPerson_notExists() {
        PersonEntity result = personService.getPerson(-1L);

        assertNull(result);
    }

    @Test
    void delete() {
        personService.delete();

        List<PersonEntity> people = personService.getPersons();

        assertTrue(people.isEmpty());
    }
}
