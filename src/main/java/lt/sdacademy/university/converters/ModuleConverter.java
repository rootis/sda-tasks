package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.Module;
import lt.sdacademy.university.models.entities.ModuleEntity;
import org.springframework.stereotype.Component;

@Component
public class ModuleConverter extends AbstractConverter<ModuleEntity, Module> {

    @Override
    public Module convert(ModuleEntity moduleEntity) {
        return new Module(moduleEntity.getId(), moduleEntity.getTitle());
    }
}
