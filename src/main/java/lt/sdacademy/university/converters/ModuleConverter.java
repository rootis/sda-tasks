package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.Module;
import lt.sdacademy.university.models.entities.ModuleEntity;
import lt.sdacademy.university.repositories.ModuleRepository;
import org.springframework.stereotype.Component;

@Component
public class ModuleConverter extends AbstractBiConverter<ModuleEntity, Module> {

    private final ModuleRepository moduleRepository;

    public ModuleConverter(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module convert(ModuleEntity moduleEntity) {
        return new Module(moduleEntity.getId(), moduleEntity.getTitle());
    }

    public ModuleEntity convertToEntity(Module module) {
        ModuleEntity result = new ModuleEntity();

        if (module.getId() != null) {
            result = moduleRepository.findById(module.getId());
        }

        result.setTitle(module.getTitle());

        return result;
    }
}
