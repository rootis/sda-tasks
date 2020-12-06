package lt.sdacademy.university.models.dto;

public class Student {

    private Long id;
    private String fullName;
    private String studyProgramTitle;

    public Student() {
    }

    public Student(Long id, String fullName, String studyProgramTitle) {
        this.id = id;
        this.fullName = fullName;
        this.studyProgramTitle = studyProgramTitle;
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
}
