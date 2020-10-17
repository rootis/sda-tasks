package lt.sdacademy.university.services;

import java.util.Properties;
import lt.sdacademy.university.models.entities.LecturerEntity;
import lt.sdacademy.university.models.entities.ModuleEntity;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.models.entities.StudentEntity;
import lt.sdacademy.university.models.entities.StudyProgramEntity;
import lt.sdacademy.university.models.entities.UniversityEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public final class ConnectionService {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, System.getenv("DB_URL"));
            settings.put(Environment.USER, System.getenv("DB_USER"));
            settings.put(Environment.PASS, System.getenv("DB_PASSWORD"));
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.HBM2DDL_AUTO, "validate");
            settings.put(Environment.ALLOW_JTA_TRANSACTION_ACCESS, "true");
            configuration.setProperties(settings);

            configuration.addAnnotatedClass(LecturerEntity.class);
            configuration.addAnnotatedClass(ModuleEntity.class);
            configuration.addAnnotatedClass(PersonEntity.class);
            configuration.addAnnotatedClass(StudentEntity.class);
            configuration.addAnnotatedClass(StudyProgramEntity.class);
            configuration.addAnnotatedClass(UniversityEntity.class);

            sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()
            );
        }

        return sessionFactory;
    }

    public ConnectionService() {
    }
}
