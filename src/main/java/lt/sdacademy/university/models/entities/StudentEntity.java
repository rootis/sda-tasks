package lt.sdacademy.university.models.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity extends AbstractEntity {

    @Column(name = "date_started", nullable = false)
    private LocalDate dateStarted;

    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "study_program_id", nullable = false)
    private Long studyProgramId;

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Long studyProgramId) {
        this.studyProgramId = studyProgramId;
    }
}
