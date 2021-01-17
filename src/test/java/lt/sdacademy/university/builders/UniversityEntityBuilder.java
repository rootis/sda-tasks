package lt.sdacademy.university.builders;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import lt.sdacademy.university.models.entities.UniversityLecturerEntity;

public final class UniversityEntityBuilder {

    private Long id;
    private String code;
    private String title;
    private List<UniversityLecturerEntity> universityLecturers = new ArrayList<>();
    private List<StudyProgramEntity> studyPrograms = new ArrayList<>();

    private UniversityEntityBuilder() {
    }

    public static UniversityEntityBuilder init() {
        return new UniversityEntityBuilder();
    }

    public UniversityEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UniversityEntityBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public UniversityEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public UniversityEntityBuilder withUniversityLecturers(List<UniversityLecturerEntity> universityLecturers) {
        this.universityLecturers = universityLecturers;
        return this;
    }

    public UniversityEntityBuilder withStudyPrograms(List<StudyProgramEntity> studyPrograms) {
        this.studyPrograms = studyPrograms;
        return this;
    }

    public UniversityEntity build() {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setId(id);
        universityEntity.setCode(code);
        universityEntity.setTitle(title);
        universityEntity.setUniversityLecturers(universityLecturers);
        universityEntity.setStudyPrograms(studyPrograms);
        return universityEntity;
    }
}
