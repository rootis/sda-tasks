package lt.sdacademy.university.models.dto;

import java.time.LocalDate;
import lt.sdacademy.university.models.StudyType;

public class StudentSave {

    private Long id;
    private LocalDate dateStarted;
    private StudyType studyType;
    private Long studyProgramId;
    private Person person;

    public StudentSave() {
    }

    public StudentSave(Long id, LocalDate dateStarted, StudyType studyType, Long studyProgramId, Person person) {
        this.id = id;
        this.dateStarted = dateStarted;
        this.studyType = studyType;
        this.studyProgramId = studyProgramId;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public Long getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Long studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
