package lt.sdacademy.university.models.dto;

public class StudyProgram {

    private Long id;
    private String title;
    private String universityCode;
    private Integer numberOfModules;

    public StudyProgram(Long id, String title, String universityCode, Integer numberOfModules) {
        this.id = id;
        this.title = title;
        this.universityCode = universityCode;
        this.numberOfModules = numberOfModules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public Integer getNumberOfModules() {
        return numberOfModules;
    }

    public void setNumberOfModules(Integer numberOfModules) {
        this.numberOfModules = numberOfModules;
    }
}
