package lt.sdacademy.university.models.entities;

import java.util.ArrayList;
import java.util.List;

public class StudyProgramEntity extends AbstractEntity {

    private String title;

    private List<ModuleEntity> modules = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }
}

