package lt.sdacademy.university.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.Gender;
import lt.sdacademy.university.models.entities.PersonEntity;
import lt.sdacademy.university.services.ConnectionService;

public class PersonRepository {

    public List<PersonEntity> findAll() {
        List<PersonEntity> result = new ArrayList<>();

        try {
            Statement s = ConnectionService.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM person");

            while (rs.next()) {
                PersonEntity person = new PersonEntity();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setGender(Gender.valueOf(rs.getString("gender")));
                result.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
