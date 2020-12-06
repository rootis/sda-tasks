package lt.sdacademy.university.models.dto;

import java.util.List;

public class StudyProgram {

    private Long id;

    private String title;

    private List<String> modules;

    private String universityTitle;

    public StudyProgram() {
    }

    public StudyProgram(Long id, String title, List<String> modules, String universityTitle) {
        this.id = id;
        this.title = title;
        this.modules = modules;
        this.universityTitle = universityTitle;
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

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    public String getUniversityTitle() {
        return universityTitle;
    }

    public void setUniversityTitle(String universityTitle) {
        this.universityTitle = universityTitle;
    }
}
