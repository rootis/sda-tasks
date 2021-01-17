package lt.sdacademy.university.models.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class University {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String code;

    private String title;

    private Integer numberOfStudyPrograms;

    private List<StudyProgram> studyPrograms;

    public University() {
    }

    public University(Long id, String code, String title, Integer numberOfStudyPrograms, List<StudyProgram> studyPrograms) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.numberOfStudyPrograms = numberOfStudyPrograms;
        this.studyPrograms = studyPrograms;
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

    public List<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgram> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}
