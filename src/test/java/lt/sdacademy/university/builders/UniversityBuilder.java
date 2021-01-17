package lt.sdacademy.university.builders;

import java.util.List;
import lt.sdacademy.university.models.dto.StudyProgram;
import lt.sdacademy.university.models.dto.University;

public final class UniversityBuilder {

    private Long id;
    private String code;
    private String title;
    private Integer numberOfStudyPrograms;
    private List<StudyProgram> studyPrograms;

    private UniversityBuilder() {
    }

    public static UniversityBuilder init() {
        return new UniversityBuilder();
    }

    public UniversityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UniversityBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public UniversityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public UniversityBuilder withNumberOfStudyPrograms(Integer numberOfStudyPrograms) {
        this.numberOfStudyPrograms = numberOfStudyPrograms;
        return this;
    }

    public UniversityBuilder withStudyPrograms(List<StudyProgram> studyPrograms) {
        this.studyPrograms = studyPrograms;
        return this;
    }

    public University build() {
        return new University(id, code, title, numberOfStudyPrograms, studyPrograms);
    }
}
