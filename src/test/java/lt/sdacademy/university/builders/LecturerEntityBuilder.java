package lt.sdacademy.university.builders;

import lt.sdacademy.university.models.entities.LecturerEntity;
import lt.sdacademy.university.models.entities.PersonEntity;

public final class LecturerEntityBuilder {

    private Long id;
    private PersonEntity person;

    private LecturerEntityBuilder() {
    }

    public static LecturerEntityBuilder init() {
        return new LecturerEntityBuilder();
    }

    public LecturerEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public LecturerEntityBuilder withPerson(PersonEntity person) {
        this.person = person;
        return this;
    }

    public LecturerEntity build() {
        LecturerEntity lecturerEntity = new LecturerEntity();
        lecturerEntity.setId(id);
        lecturerEntity.setPerson(person);
        return lecturerEntity;
    }
}
