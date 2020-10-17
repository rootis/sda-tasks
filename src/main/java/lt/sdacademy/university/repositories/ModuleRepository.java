package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.ModuleEntity;

public class ModuleRepository extends AbstractRepository<ModuleEntity> {

    @Override
    protected Class<ModuleEntity> getEntityClass() {
        return ModuleEntity.class;
    }
}
