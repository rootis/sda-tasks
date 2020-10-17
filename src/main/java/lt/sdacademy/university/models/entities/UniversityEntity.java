package lt.sdacademy.university.models.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "university")
public class UniversityEntity extends AbstractEntity {

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @Column(name = "title", length = 250, nullable = false)
    private String title;

    @JoinTable(name = "university_lecturer", joinColumns = @JoinColumn(name = "university_id"), inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<LecturerEntity> lecturers = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LecturerEntity> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<LecturerEntity> lecturers) {
        this.lecturers = lecturers;
    }
}
