package by.it.emelyanov.project.java.dao;


import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.connection.ConnectionCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends AbstractDAO implements InterfaceDAO<Orders> {

    @Override
    public Orders read(int id) {
        List<Orders> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Orders order) {
        String sql = String.format(
                "insert into orders(FK_User,FK_Room,Arrive_Date,Return_Date,Bill) values('%d','%d','%s','%s','%f');",
                order.getfK_User(), order.getfK_Room(), order.getArrive_Date(), order.getReturn_Date(), order.getBill()
        );
        order.setId(executeUpdate(sql));
        return (order.getId() > 0);
    }

    @Override
    public boolean update(Orders order) {
        String sql = String.format(
                "UPDATE orders SET FK_User = '%d', FK_Room = '%d', Arrive_Date = '%s', Return_Date='%s', Bill='%f' WHERE orders.ID = %d",
                order.getfK_User(), order.getfK_Room(), order.getArrive_Date(), order.getReturn_Date(), order.getBill(), order.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Orders order) {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `orders`.`ID` = %d;", order.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Orders> getAll(String WHERE) {
        List<Orders> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("ID"));
                order.setfK_User(rs.getInt("FK_User"));
                order.setfK_Room(rs.getInt("FK_Room"));
                order.setArrive_Date(rs.getString("Arrive_Date"));
                order.setReturn_Date(rs.getString("Return_Date"));
                order.setBill(rs.getFloat("Bill"));

                orders.add(order);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return orders;
    }
}
