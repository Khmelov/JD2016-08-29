package by.it.sukora.PROJECT.java.custom_dao;

import by.it.sukora.PROJECT.java.beans.patients;
import by.it.sukora.PROJECT.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class PatientsDAO extends AbstractDAO implements InterfaceDAO<patients> {
    @Override
    public patients read(int id) {
        List<patients> patientses = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (patientses.size() > 0) {
            return patientses.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(patients patients) {
        String sql = String.format(
                "insert INTO patients(" +
                        "DateOfBirth," +
                        "Email," +
                        "FirstName," +
                        "LastName," +
                        "PasportNum," +
                        "Sex," +
                        "id_address," +
                        "id_logpass)" +
                        " values('%s','%s','%s','%s','%s','%s',%d,%d);",
                patients.getDateOfBirth(),
                patients.getEmail(),
                patients.getFirstName(),
                patients.getLastName(),
                patients.getPasportNum(),
                patients.getSex(),
                patients.getId_address(),
                patients.getId_logpass()
        );
        patients.setId(executeUpdate(sql));
        return (patients.getId() > 0);
    }

    @Override
    public boolean update(patients patients) {
        String sql = String.format(
                "UPDATE `address` SET" +
                        " `DateOfBirth` = '%s'," +
                        " `Email` = '%s'," +
                        " `FirstName` = '%s'," +
                        " `LastName` = '%s'," +
                        " `PasportNum` = '%s'," +
                        " `Sex` = '%s'," +
                        " `id_address` = '%d'," +
                        " `id_logpass` = '%d'" +
                        " WHERE `address`.`id` = %d",
                patients.getDateOfBirth(),
                patients.getEmail(),
                patients.getFirstName(),
                patients.getLastName(),
                patients.getPasportNum(),
                patients.getSex(),
                patients.getId_address(),
                patients.getId_logpass(),
                patients.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(patients patients) {
        String sql = String.format(
                "DELETE FROM `patients` WHERE `patients`.`ID` = %d;", patients.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<patients> getAll(String WHERE) {
        List<patients> patientses = new ArrayList<>();
        String sql = "SELECT * FROM patients " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                patients patients = new patients();
                patients.setDateOfBirth(rs.getDate("DateOfBirth"));
                patients.setEmail(rs.getString("Email"));
                patients.setFirstName(rs.getString("FirstName"));
                patients.setLastName(rs.getString("LastName"));
                patients.setPasportNum(rs.getString("PasportNum"));
                patients.setSex(rs.getString("Sex"));
                patients.setId_address(rs.getInt("id_address"));
                patients.setId_logpass(rs.getInt("id_logpass"));;
                patientses.add(patients);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientses;
    }
}
