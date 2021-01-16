package lt.sdacademy.university.converters;

import lt.sdacademy.university.models.StudyType;
import lt.sdacademy.university.models.dto.Student;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.repositories.PersonRepository;
import lt.sdacademy.university.repositories.StudentRepository;
import lt.sdacademy.university.repositories.StudyProgramRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter extends AbstractConverter<StudentEntity, Student> {

    private final StudentRepository studentRepository;
    private final PersonRepository personRepository;
    private final StudyProgramRepository studyProgramRepository;

    public StudentConverter(StudentRepository studentRepository,
        PersonRepository personRepository,
        StudyProgramRepository studyProgramRepository) {
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public Student convert(StudentEntity studentEntity) {
        return new Student(
            studentEntity.getId(),
            studentEntity.getPerson().getName() + " " + studentEntity.getPerson().getSurname(),
            studentEntity.getStudyProgram().getTitle(),
            studentEntity.getDateStarted(),
            studentEntity.getStudyType().toString());
    }

/*    public StudentEntity convertToEntity(Student student) {
        StudentEntity result = new StudentEntity();
        if (student.getId() != null) {
            result = studentRepository.findById(student.getId());
        } else {
            String fullname = student.getFullName();
            int spaceIndex = fullname.indexOf(" ");
            String name = fullname.substring(0, spaceIndex);
            String surname = fullname.substring(spaceIndex + 1);
            PersonEntity personEntity = personRepository.findFirstByNameAndSurname(name, surname);
            result.setPerson(personEntity);
        }
        result.setStudyType(StudyType.valueOf(student.getStudyType()));
        result.setDateStarted(student.getDateStarted());
        result.setStudyProgram(studyProgramRepository.findOneByTitle(student.getStudyProgramTitle()));
        return result;
    }*/
}
