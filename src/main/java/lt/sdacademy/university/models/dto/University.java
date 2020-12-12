package lt.sdacademy.university.models.dto;

public class University {

    private Long id;
    private String code;
    private String title;
    private Integer numberOfStudyPrograms;

    public University(Long id, String code, String title, Integer numberOfStudyPrograms) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.numberOfStudyPrograms = numberOfStudyPrograms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getNumberOfStudyPrograms() {
        return numberOfStudyPrograms;
    }

    public void setNumberOfStudyPrograms(Integer numberOfStudyPrograms) {
        this.numberOfStudyPrograms = numberOfStudyPrograms;
    }
}
