package lt.sdacademy.university;

import lt.sdacademy.university.services.StudyProgramService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UniversityApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("lt.sdacademy.university");

        System.out.println(applicationContext.getBean(StudyProgramService.class).getStudyProgram());
    }
}
