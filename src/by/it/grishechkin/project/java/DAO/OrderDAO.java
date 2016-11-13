package by.it.grishechkin.project.java.DAO;

import by.it.grishechkin.project.java.beans.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Yury on 31.10.2016.
 */
public class OrderDAO implements IDAO<Order> {
    @Override
    public int create(Order order) {
        int key = 0;
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"INSERT INTO `order` (Term, FK_Client, FK_Auto, Pay, Refund)" +
                            " VALUES (%d, %d, %d, %d, %d);",
                    order.getTerm(), order.getFK_Client(), order.getFK_Auto(), order.getPay(), order.getRefund()), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(key);
        return key;
    }

    @Override
    public List<Order> read(Order order) {
        List<Order> orders = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM `order` WHERE `order`.ID=" + order.getID() ));
            orders = exequte(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(Order order) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE `order` SET Term='%d', FK_Client='%d', FK_Auto='%d', Pay='%d', Refund='%d' WHERE `order`.ID=" + order.getID() + ";",
                    order.getTerm(), order.getFK_Client(), order.getFK_Auto(), order.getPay(), order.getRefund()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Order order) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"DELETE FROM `order` WHERE `order`.ID=" + order.getID() + ";"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM `order`;"));
            orders = exequte(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getAll(int id) {
        List<Order> orders = new ArrayList<>();
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM `order` WHERE `order`.FK_Client='" + id + "';"));
            orders = exequte(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private List<Order> exequte(ResultSet resultSet) {
        List<Order> orders = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Order order = new Order();
                order.setID(resultSet.getInt("ID"));
                order.setTerm(resultSet.getInt("Term"));
                order.setFK_Client(resultSet.getInt("FK_Client"));
                order.setFK_Auto(resultSet.getInt("FK_Auto"));
                order.setPay(resultSet.getInt("Pay"));
                order.setRefund(resultSet.getInt("Refund"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
