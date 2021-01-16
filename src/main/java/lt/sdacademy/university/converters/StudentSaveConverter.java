package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.dto.StudentSave;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.repositories.StudentRepository;
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentSaveConverter extends AbstractBiConverter<StudentEntity, StudentSave> {

    private final PersonConverter personConverter;
    private final StudentRepository studentRepository;
    private final StudyProgramRepository studyProgramRepository;

    public StudentSaveConverter(PersonConverter personConverter, StudentRepository studentRepository, StudyProgramRepository studyProgramRepository) {
        this.personConverter = personConverter;
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public StudentEntity convertToEntity(StudentSave student) {
        StudentEntity result = student.getId() == null
            ? new StudentEntity()
            : studentRepository.getOne(student.getId());
        result.setStudyProgram(studyProgramRepository.findById(student.getStudyProgramId()));
        result.setDateStarted(student.getDateStarted());
        result.setPerson(personConverter.convertToEntity(student.getPerson()));
        result.setStudyType(student.getStudyType());

        return result;
    }

    @Override
    public StudentSave convert(StudentEntity student) {
        return new StudentSave(
            student.getId(),
            student.getDateStarted(),
            student.getStudyType(),
            student.getStudyProgram().getId(),
            personConverter.convert(student.getPerson())
        );
    }
}
