package by.it.grishechkin.jd03_03.DAO;

import by.it.grishechkin.jd03_03.beans.Order;

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
                    order.getTerm(), order.getFK_Client(), order.getFK_Auto(), order.isPay(), order.isRefund()), Statement.RETURN_GENERATED_KEYS);
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
    public void read(int id) {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM `order` WHERE `order`.ID=" + id + ";" ));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {
        try (Statement statement = MyConnection.getStatement()){
            statement.executeUpdate(String.format(Locale.ENGLISH,"UPDATE `order` SET Term='%d', FK_Client='%d', FK_Auto='%d', Pay='%d', Refund='%d' WHERE `order`.ID=" + order.getID() + ";",
                    order.getTerm(), order.getFK_Client(), order.getFK_Auto(), order.isPay(), order.isRefund()));
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
    public void getAll() {
        try (Statement statement = MyConnection.getStatement()){
            ResultSet resultSet = statement.executeQuery(String.format(Locale.ENGLISH,"SELECT * FROM `order`;"));
            AbstractDAO.readResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
