package by.it.emelyanov.project.java.dao;


import by.it.emelyanov.project.java.beans.Rooms;
import by.it.emelyanov.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO extends AbstractDAO implements InterfaceDAO<Rooms> {
    @Override
    public Rooms read(int id) {
        List<Rooms> rooms = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rooms room) {
        String sql = String.format(
                "insert into rooms(Floor,Room_Number,Cost,FK_Type) values('%s','%s','%s',%d);",
                room.getFloor(), room.getRoom_Number(), room.getCost(), room.getfK_Type()
        );
        room.setId(executeUpdate(sql));
        return (room.getId() > 0);
    }

    @Override
    public boolean update(Rooms room) {
        String sql = String.format(
                "UPDATE rooms SET Floor = '%d', Room_Number = '%d', Cost = '%f', FK_Type=%d WHERE rooms.ID = %d",
                room.getFloor(), room.getRoom_Number(), room.getCost(), room.getfK_Type(), room.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rooms room) {
        String sql = String.format(
                "DELETE FROM `rooms` WHERE `rooms`.`ID` = %d;", room.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Rooms> getAll(String WHERE) {
        List<Rooms> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Rooms room = new Rooms();
                room.setId(rs.getInt("ID"));
                room.setFloor(rs.getInt("Floor"));
                room.setRoom_Number(rs.getInt("Room_Number"));
                room.setCost(rs.getFloat("Cost"));
                room.setfK_Type(rs.getInt("FK_Type"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return rooms;
    }

    public static float getCost(int id) {

        String sql = "SELECT Cost FROM rooms WHERE rooms.ID ='" + id + "'";
        float cost = 0;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                cost = rs.getFloat("Cost");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }
}

