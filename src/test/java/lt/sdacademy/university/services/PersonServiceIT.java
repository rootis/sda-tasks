package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import javax.transaction.Transactional;
import lt.sdacademy.university.models.entities.PersonEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
@Tag("integration")
class PersonServiceIT {

    @Autowired
    private PersonService personService;

    @Test
    void getPeople() {
        List<PersonEntity> result = personService.getPeople();

        assertFalse(result.isEmpty());
    }

    @Test
    void getPeopleByName() {
        List<PersonEntity> result = personService.getPeopleByName("Rutenis");

        assertFalse(result.isEmpty());
        assertEquals("Rutenis", result.get(0).getName());
    }
}
