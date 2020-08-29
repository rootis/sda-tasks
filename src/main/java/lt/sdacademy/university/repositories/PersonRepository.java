package lt.sdacademy.university.repositories;

import java.sql.Connection;
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

    private final Connection connection;

    public PersonRepository() {
        this.connection = ConnectionService.getConnection();
    }

    public List<PersonEntity> getPersons() {
        List<PersonEntity> result = new ArrayList<>();

        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                result.add(getPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void delete(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PersonEntity getPerson(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getPerson(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PersonEntity getPersonBySurname(String surname) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM person WHERE surname = ?");
            ps.setString(1, surname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getPerson(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete() {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM person");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePerson(PersonEntity person) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO person (name, surname, gender) VALUES (?, ?, ?)");
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getGender().toString().toLowerCase());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(PersonEntity person) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE person SET name = ?, surname = ?, gender = ? WHERE id = ?");
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getGender().toString().toLowerCase());
            ps.setLong(4, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PersonEntity getPerson(ResultSet resultSet) throws SQLException {
        PersonEntity result = new PersonEntity();

        result.setId(resultSet.getLong("id"));
        result.setName(resultSet.getString("name"));
        result.setSurname(resultSet.getString("surname"));
        result.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));

        return result;
    }
}
