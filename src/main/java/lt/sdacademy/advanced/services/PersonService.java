package lt.sdacademy.advanced.services;

import java.util.Comparator;
import java.util.List;
import lt.sdacademy.advanced.models.Person;

public class PersonService {

    public Person getTheOldestPerson(List<Person> people) {
        if (people == null) {
            return null;
        }

        return people.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);
    }
}
