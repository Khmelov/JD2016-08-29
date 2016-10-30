package by.it.sukora.jd03_03.custom_dao;

import by.it.sukora.jd03_03.beans.diagnosis;
import by.it.sukora.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class DiagnosisDAO extends AbstractDAO implements InterfaceDAO<diagnosis> {
    @Override
    public diagnosis read(int id) {
        List<diagnosis> diagnosises = getAll("WHERE id=" + id + " LIMIT 0,5");
        if (diagnosises.size() > 0) {
            return diagnosises.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(diagnosis diagnosis) {
        String sql = String.format(
                "insert INTO diagnosis(" +
                        "Disease," +
                        "PeriodEnd," +
                        "PeriodStart," +
                        "Recipe," +
                        "Siptomps)" +
                        " values('%s','%s','%s','%s','%s');",
                diagnosis.getDisease(),
                diagnosis.getPeriodEnd(),
                diagnosis.getPeriodStart(),
                diagnosis.getRecipe(),
                diagnosis.getSiptomps()
        );
        diagnosis.setId(executeUpdate(sql));
        return (diagnosis.getId() > 0);
    }

    @Override
    public boolean update(diagnosis diagnosis) {
        String sql = String.format(
                "UPDATE `diagnosis` SET" +
                        " `Disease` = '%s'," +
                        " `PeriodEnd` = '%s'," +
                        " `PeriodStart` = '%s'," +
                        " `Recipe` = '%s'," +
                        " `Siptomps` = '%s'" +
                        " WHERE `diagnosis`.`id` = %d",
                diagnosis.getDisease(),
                diagnosis.getPeriodEnd(),
                diagnosis.getPeriodStart(),
                diagnosis.getRecipe(),
                diagnosis.getSiptomps(),
                diagnosis.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(diagnosis diagnosis) {
        String sql = String.format(
                "DELETE FROM `diagnosis` WHERE `diagnosis`.`ID` = %d;", diagnosis.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<diagnosis> getAll(String WHERE) {
        List<diagnosis> diagnosises = new ArrayList<>();
        String sql = "SELECT * FROM diagnosis " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                diagnosis diagnosiss = new diagnosis();
                diagnosiss.setId(rs.getInt("id"));
                diagnosiss.setDisease(rs.getString("Disease"));
                diagnosiss.setPeriodEnd(rs.getDate("PeriodEnd"));
                diagnosiss.setPeriodStart(rs.getDate("PeriodStart"));
                diagnosiss.setRecipe(rs.getString("Recipe"));
                diagnosiss.setSiptomps(rs.getString("Siptomps"));
                diagnosises.add(diagnosiss);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosises;
    }
}

