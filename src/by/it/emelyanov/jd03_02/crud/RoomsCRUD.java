package by.it.emelyanov.jd03_02.crud;

import java.sql.*;

public class RoomsCRUD {
    public Rooms create(Rooms room) throws SQLException {

        String createRoomSQL = String.format(
                "insert into rooms(Floor,Room_Number,Cost,FK_Type) values('%s','%s','%s',%d);",
                room.getFloor(), room.getRoom_Number(), room.getCost(), room.getfK_Type()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createRoomSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    room.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return room;
    }

    public Rooms read(int id) throws SQLException {
        Rooms roomResult = null;
        String readRoomSQL = "SELECT * FROM rooms where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readRoomSQL);
            if (resultSet.next()) {
                roomResult = new Rooms(
                        resultSet.getInt("ID"),
                        resultSet.getInt("Floor"),
                        resultSet.getInt("Room_Number"),
                        resultSet.getFloat("Cost"),
                        resultSet.getInt("FK_Type"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return roomResult;
    }

    public Rooms update(Rooms room) throws SQLException {
        Rooms roomResult = null;
        String updateRoomSQL = String.format(
                "UPDATE rooms SET Floor = '%d', Room_Number = '%d', Cost = '%f', FK_Type=%d WHERE rooms.ID = %d",
                room.getFloor(), room.getRoom_Number(), room.getCost(), room.getfK_Type(), room.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateRoomSQL) == 1)
                roomResult = room;
        } catch (SQLException e) {
            throw e;
        }
        return roomResult;
    }

    public boolean delete(Rooms room) throws SQLException {
        String deleteRoomSQL = String.format("DELETE FROM rooms WHERE rooms.ID = %d", room.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteRoomSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
