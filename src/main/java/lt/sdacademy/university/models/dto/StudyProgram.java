package lt.sdacademy.university.models.dto;

import java.util.List;

public class StudyProgram {

    private Long id;
    private String title;
    private String universityCode;
    private List<Module> modules;

    public StudyProgram() {
    }

    public StudyProgram(Long id, String title, String universityCode, List<Module> modules) {
        this.id = id;
        this.title = title;
        this.universityCode = universityCode;
        this.modules = modules;
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

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
