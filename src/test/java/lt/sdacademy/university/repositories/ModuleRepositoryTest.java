package lt.sdacademy.university.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lt.sdacademy.university.models.entities.ModuleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModuleRepositoryTest {

    private ModuleRepository moduleRepository;

    @BeforeEach
    void setUp() {
        moduleRepository = new ModuleRepository();
    }

    @Test
    void findAll() {
        List<ModuleEntity> result = moduleRepository.findAll();

        assertFalse(result.isEmpty());
    }

    @Test
    void findOne() {
        ModuleEntity result = moduleRepository.findOne(1L);

        assertNotNull(result);
        assertFalse(result.getStudyPrograms().isEmpty());
    }
}
