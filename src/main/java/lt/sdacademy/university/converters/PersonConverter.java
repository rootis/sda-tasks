package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.dto.Person;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.repositories.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter extends AbstractConverter<PersonEntity, Person> {

    private final PersonRepository personRepository;

    public PersonConverter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person convert(PersonEntity personEntity) {
        return new Person(personEntity.getId(), personEntity.getName(), personEntity.getSurname(), personEntity.getGender());
    }

    public PersonEntity convertToEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        if (person.getId() != null) {
            personEntity = personRepository.findById(person.getId());
        }
        personEntity.setName(person.getName());
        personEntity.setSurname(person.getSurname());
        personEntity.setGender(person.getGender());
        return personEntity;
    }
}
