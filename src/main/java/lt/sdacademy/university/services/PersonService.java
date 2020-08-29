package lt.sdacademy.university.services;

import java.util.List;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.repositories.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        personRepository = new PersonRepository();
    }

    public List<PersonEntity> getPersons() {
        return personRepository.getPersons();
    }

    public void delete() {
        personRepository.delete();
    }
}
