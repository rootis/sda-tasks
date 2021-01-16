package lt.sdacademy.university.models.dto;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String fullName;
    private String studyProgramTitle;
    private LocalDate dateStarted;
    private String studyType;

    public Student() {
    }

    public Student(Long id, String fullName, String studyProgramTitle,
        LocalDate dateStarted, String studyType) {
        this.id = id;
        this.fullName = fullName;
        this.studyProgramTitle = studyProgramTitle;
        this.dateStarted = dateStarted;
        this.studyType = studyType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudyProgramTitle() {
        return studyProgramTitle;
    }

    public void setStudyProgramTitle(String studyProgramTitle) {
        this.studyProgramTitle = studyProgramTitle;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }
}
