package by.it.emelyanov.project.java.dao;

import by.it.emelyanov.project.java.beans.Types;
import by.it.emelyanov.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.*;

public class TypesDAO extends AbstractDAO implements InterfaceDAO<Types> {

    @Override
    public Types read(int id) {
        List<Types> types = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (types.size() > 0) {
            return types.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Types type) {
        String sql = String.format(
                "insert INTO types(Room_Type) values('%s',);", type.getRoom_type()
        );
        type.setId(executeUpdate(sql));
        return (type.getId() > 0);
    }

    @Override
    public boolean update(Types type) {
        String sql = String.format(
                "UPDATE `types` SET `Room_Type` = '%s', WHERE `types`.`ID` = %d",
                type.getRoom_type(), type.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Types type) {
        String sql = String.format(
                "DELETE FROM `types` WHERE `types`.`ID` = %d;", type.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Types> getAll(String WHERE) {
        List<Types> roles = new ArrayList<>();
        String sql = "SELECT * FROM types " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Types type = new Types();
                type.setId(rs.getInt("ID"));
                type.setRoom_type(rs.getString("Room_type"));
                roles.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}

