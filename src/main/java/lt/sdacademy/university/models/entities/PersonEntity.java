package lt.sdacademy.university.models.entities;

import lt.sdacademy.university.models.Gender;

public class PersonEntity extends AbstractEntity {

    private String name;
    private String surname;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
