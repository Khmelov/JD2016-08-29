package by.it.sukora.PROJECT.java.custom_dao;

import by.it.sukora.PROJECT.java.beans.medicalcard;
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
public class MedicalcardDAO extends AbstractDAO implements InterfaceDAO<medicalcard> {
    @Override
    public medicalcard read(int id) {
        List<medicalcard> medicalcardsss = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (medicalcardsss.size() > 0) {
            return medicalcardsss.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(medicalcard medicalcard) {
        String sql = String.format(
                "insert INTO medicalcard(" +
                        "id_diagnosis," +
                        "id_patient," +
                        " values(%d,%d);",
                medicalcard.getId_diagnosis(),
                medicalcard.getId_patient()
        );
        medicalcard.setId(executeUpdate(sql));
        return (medicalcard.getId() > 0);
    }

    @Override
    public boolean update(medicalcard medicalcard) {
        String sql = String.format(
                "UPDATE `medicalcard` SET" +
                        " `id_diagnosis` = '%d'," +
                        " `id_patient` = '%d'" +
                        " WHERE `medicalcard`.`id` = %d",
                medicalcard.getId_diagnosis(),
                medicalcard.getId_patient(),
                medicalcard.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(medicalcard medicalcard) {
        String sql = String.format(
                "DELETE FROM `medicalcard` WHERE `medicalcard`.`ID` = %d;", medicalcard.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<medicalcard> getAll(String WHERE) {
        List<medicalcard> medicalcardsss = new ArrayList<>();
        String sql = "SELECT * FROM medicalcard " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                medicalcard medicalcard = new medicalcard();
                medicalcard.setId(rs.getInt("id"));
                medicalcard.setId_diagnosis(rs.getInt("id_diagnosis"));
                medicalcard.setId_patient(rs.getInt("id_patient"));
                medicalcardsss.add(medicalcard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalcardsss;
    }
}
