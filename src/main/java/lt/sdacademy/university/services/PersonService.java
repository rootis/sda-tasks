package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.repositories.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        personRepository = new PersonRepository();
    }

    public PersonEntity save(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> getPeople() {
        return personRepository.findAll();
    }

    public void delete(PersonEntity personEntity) {
        personRepository.delete(personEntity);
    }
}
