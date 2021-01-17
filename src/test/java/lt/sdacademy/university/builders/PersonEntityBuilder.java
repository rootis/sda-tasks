package lt.sdacademy.university.builders;

import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;

public final class PersonEntityBuilder {

    private Long id;
    private String name;
    private String surname;
    private Gender gender;

    private PersonEntityBuilder() {
    }

    public static PersonEntityBuilder init() {
        return new PersonEntityBuilder();
    }

    public PersonEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PersonEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonEntityBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonEntityBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PersonEntity build() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);
        personEntity.setName(name);
        personEntity.setSurname(surname);
        personEntity.setGender(gender);
        return personEntity;
    }
}
