package lt.sdacademy.university.models.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "study_program")
public class StudyProgramEntity extends AbstractEntity {

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Transient
    private List<ModuleEntity> modules = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity university;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }

    public UniversityEntity getUniversity() {
        return university;
    }

    public void setUniversity(UniversityEntity university) {
        this.university = university;
    }
}
