package lt.sdacademy.university.builders;

import java.math.BigDecimal;
import lt.sdacademy.university.models.entities.LecturerEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.models.entities.UniversityLecturerEntity;

public final class UniversityLecturerEntityBuilder {

    private Long id;
    private String level;
    private BigDecimal salary;
    private UniversityEntity university;
    private LecturerEntity lecturer;

    private UniversityLecturerEntityBuilder() {
    }

    public static UniversityLecturerEntityBuilder init() {
        return new UniversityLecturerEntityBuilder();
    }

    public UniversityLecturerEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UniversityLecturerEntityBuilder withLevel(String level) {
        this.level = level;
        return this;
    }

    public UniversityLecturerEntityBuilder withSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public UniversityLecturerEntityBuilder withUniversity(UniversityEntity university) {
        this.university = university;
        return this;
    }

    public UniversityLecturerEntityBuilder withLecturer(LecturerEntity lecturer) {
        this.lecturer = lecturer;
        return this;
    }

    public UniversityLecturerEntity build() {
        UniversityLecturerEntity universityLecturerEntity = new UniversityLecturerEntity();
        universityLecturerEntity.setId(id);
        universityLecturerEntity.setLevel(level);
        universityLecturerEntity.setSalary(salary);
        universityLecturerEntity.setUniversity(university);
        universityLecturerEntity.setLecturer(lecturer);
        return universityLecturerEntity;
    }
}
