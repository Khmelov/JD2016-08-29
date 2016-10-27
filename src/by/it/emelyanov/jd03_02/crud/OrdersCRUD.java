package by.it.emelyanov.jd03_02.crud;

import java.sql.*;

public class OrdersCRUD {
    public Orders create(Orders order) throws SQLException {

        String createOrderSQL = String.format(
                "insert into orders(FK_User,FK_Room,Arrive_Date,Return_Date,Bill) values('%d','%d','%s','%s','%f');",
                order.getfK_User(), order.getfK_Room(), order.getArrive_Date(), order.getReturn_Date(), order.getBill()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createOrderSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    order.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return order;
    }

    public Orders read(int id) throws SQLException {
        Orders orderResult = null;
        String readOrderSQL = "SELECT * FROM orders where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readOrderSQL);
            if (resultSet.next()) {
                orderResult = new Orders(
                        resultSet.getInt("ID"),
                        resultSet.getInt("FK_User"),
                        resultSet.getInt("FK_Room"),
                        resultSet.getString("Arrive_Date"),
                        resultSet.getString("Return_Date"),
                        resultSet.getFloat("Bill"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    public Orders update(Orders order) throws SQLException {
        Orders orderResult = null;
        String updateOrderSQL = String.format(
                "UPDATE orders SET FK_User = '%d', FK_Room = '%d', Arrive_Date = '%s', Return_Date='%s', Bill='%f' WHERE orders.ID = %d",
                order.getfK_User(), order.getfK_Room(), order.getArrive_Date(), order.getReturn_Date(), order.getBill(), order.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateOrderSQL) == 1)
                orderResult = order;
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    public boolean delete(Orders order) throws SQLException {
        String deleteOrderSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteOrderSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
