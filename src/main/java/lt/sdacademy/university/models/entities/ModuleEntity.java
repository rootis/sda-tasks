package lt.sdacademy.university.models.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "module")
public class ModuleEntity extends AbstractEntity {

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "modules")
    @Fetch(FetchMode.SUBSELECT)
    private List<StudyProgramEntity> studyPrograms = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudyProgramEntity> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgramEntity> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}
