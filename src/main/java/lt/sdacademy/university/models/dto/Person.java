package lt.sdacademy.university.models.dto;

import lt.sdacademy.university.models.Gender;

public class Person {

    private Long id;
    private String name;
    private String surname;
    private Gender gender;

    public Person(Long id, String name, String surname, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
