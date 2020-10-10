package lt.sdacademy.university.repositories;

import java.security.InvalidParameterException;
import java.sql.PreparedStatement;
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
                result.add(getPerson(rs));
            }

            rs.close();
            s.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public PersonEntity findOne(Long id) {
        String query = "SELECT * FROM person WHERE id = ?";

        try {
            PreparedStatement ps = ConnectionService.getConnection().prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getPerson(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void save(PersonEntity person) {
        String query = "INSERT INTO person (name, surname, gender) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = ConnectionService.getConnection().prepareStatement(query);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getGender().toString());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(PersonEntity person) {
        if (person == null || person.getId() == null) {
            throw new InvalidParameterException("Person and its' id cannot be null");
        }

        String query = "UPDATE person SET name = ?, surname = ?, gender = ? WHERE id = ?";

        try {
            PreparedStatement ps = ConnectionService.getConnection().prepareStatement(query);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getGender().toString());
            ps.setLong(4, person.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Long id) {
        String query = "DELETE from person WHERE id = ?";

        try {
            PreparedStatement ps = ConnectionService.getConnection().prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private PersonEntity getPerson(ResultSet rs) throws SQLException {
        PersonEntity person = new PersonEntity();

        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surname"));
        person.setGender(Gender.valueOf(rs.getString("gender")));

        return person;
    }
}
