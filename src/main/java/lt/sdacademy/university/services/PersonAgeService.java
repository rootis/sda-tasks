package lt.sdacademy.university.services;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lt.sdacademy.university.models.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonAgeService {

/*    public Person getOldestPerson(List<Person> people) {
        return null;
    }

    public Map<String, List<Person>> getPeopleByName(List<Person> people) {
        return people.stream().collect(groupingBy(Person::getName));
    }

    public Map<Integer, List<Person>> getPeopleByAge(List<Person> people) {
        return people.stream().collect(groupingBy(Person::getAge));
    }

    public Map<Integer, List<String>> getNamesByAge(List<Person> people) {
        return people.stream()
            .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
    }

    public Map<String, Double> getAverageNameAge(List<Person> people) {
        Map<String, Double> result = new HashMap<>();
        getPeopleByName(people).forEach((key, value) -> result.put(key, value.stream().mapToDouble(Person::getAge).average().orElse(0)));

        return result;
    }*/
}
