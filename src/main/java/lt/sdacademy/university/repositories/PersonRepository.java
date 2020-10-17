package lt.sdacademy.university.repositories;

import lt.sdacademy.university.models.entities.PersonEntity;

public class PersonRepository extends AbstractRepository<PersonEntity> {

    @Override
    protected Class<PersonEntity> getEntityClass() {
        return PersonEntity.class;
    }
}
