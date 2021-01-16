package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lt.sdacademy.university.models.dto.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonAgeServiceTest {

/*    private PersonAgeService personAgeService;

    @BeforeEach
    void setUp() {
        personAgeService = new PersonAgeService();
    }

    @Test
    void getNamesByAge() {
        Person rutenis = new Person("Rutenis", 25);
        Person viktorija = new Person("Viktorija", 18);
        Person paulius = new Person("Paulius", 24);
        Person tadas = new Person("Tadas", 18);

        List<Person> people = new ArrayList<>();
        people.add(rutenis);
        people.add(viktorija);
        people.add(paulius);
        people.add(tadas);
        List<String> expectedNames = Arrays.asList("Viktorija", "Tadas");

        Map<Integer, List<String>> grouped = personAgeService.getNamesByAge(people);

        assertNotNull(grouped);
        assertEquals(2, grouped.get(18).size());
        assertTrue(expectedNames.contains(grouped.get(18).get(0)));
        assertTrue(expectedNames.contains(grouped.get(18).get(1)));
        assertEquals(1, grouped.get(25).size());
        assertEquals("Rutenis", grouped.get(25).get(0));
        assertEquals(1, grouped.get(24).size());
    }

    @Test
    void getNamesByAge_emptyList() {
        Map<Integer, List<String>> result = personAgeService.getNamesByAge(new ArrayList<>());

        assertTrue(result.isEmpty());
    }*/
}
