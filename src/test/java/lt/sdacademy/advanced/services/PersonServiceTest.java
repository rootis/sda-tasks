package lt.sdacademy.advanced.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import lt.sdacademy.advanced.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
    }

    @Test
    void getTheOldestPerson() {
        List<Person> people = Arrays.asList(
            new Person("Tomas", 28),
            new Person("Andrius", 33),
            new Person("Ieva", 24),
            new Person("Audrius", 18)
        );

        Person result = personService.getTheOldestPerson(people);

        assertEquals(33, result.getAge());
        assertEquals("Andrius", result.getName());
    }

    @Test
    void getTheOldestPerson_nullPeople() {
        Person result = personService.getTheOldestPerson(null);

        assertNull(result);
    }
}
