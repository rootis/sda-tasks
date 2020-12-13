package lt.sdacademy.university.models.entities;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "university_lecturer")
public class UniversityLecturerEntity extends AbstractEntity {

    @Column(name = "level", length = 50, nullable = false)
    private String level;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private LecturerEntity lecturer;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public UniversityEntity getUniversity() {
        return university;
    }

    public void setUniversity(UniversityEntity university) {
        this.university = university;
    }

    public LecturerEntity getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerEntity lecturer) {
        this.lecturer = lecturer;
    }
}
