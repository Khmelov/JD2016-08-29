package by.it.tsydzik.project.java.custom_dao;


import by.it.tsydzik.project.java.beans.Rent;
import by.it.tsydzik.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentDAO extends AbstractDAO implements InterfaceDAO<Rent> {
    @Override
    public List<Rent> getAll(String WHERE) {
        List<Rent> rents = new ArrayList<>();
        String sql = "SELECT * FROM rent " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Rent rent = new Rent();
                rent.setId(rs.getInt("id"));
                rent.setStartTime(rs.getDate("startTime"));
                rent.setEndTime(rs.getDate("endTime"));
                rent.setClientId(rs.getInt("clientId"));
                rent.setAutoId(rs.getInt("autoId"));
                rents.add(rent);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return rents;
    }

    @Override
    public Rent read(int id) {
        List<Rent> rents = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (rents.size() > 0) {
            return rents.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rent rent) {
        String sql = String.format(
                "insert INTO rent(startTime,endTime,clientId,autoId)" +
                        " values('%s','%s',%d,%d);",
                rent.getStartTime(), rent.getEndTime(), rent.getClientId(), rent.getAutoId()
        );
        rent.setId(executeUpdate(sql));
        return (rent.getId() > 0);
    }

    @Override
    public boolean update(Rent rent) {
        //TODO '%s' для даты как??????
        String sql = String.format(
                "UPDATE `rent` SET " +
                        "`startTime` = '%s', " +            //???????
                        "`endTime` = '%s', " +              //???????
                        "`clientId` = %d, " +
                        "`autoId`=%d " +
                        "WHERE `rent`.`id` = %d",
                rent.getStartTime(),
                rent.getEndTime(),
                rent.getClientId(),
                rent.getAutoId(),
                rent.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rent rent) {
        String sql = String.format(
                "DELETE FROM `rent` WHERE `rent`.`id` = %d;", rent.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
