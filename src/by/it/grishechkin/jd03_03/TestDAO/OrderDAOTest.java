package by.it.grishechkin.jd03_03.TestDAO;

import by.it.grishechkin.jd03_03.DAO.OrderDAO;
import by.it.grishechkin.jd03_03.beans.Order;

/**
 * Created by Yury on 31.10.2016.
 */
public class OrderDAOTest {

    public static void main(String[] args) {
        Order order = new Order(0, 25102016, 3, 3, 1, 1);
        OrderDAO object = new OrderDAO();
        order.setID(object.create(order));
        System.out.println("Before update");
        object.read(order.getID());
        order.setFK_Client(1);
        order.setFK_Auto(1);

        object.update(order);
        System.out.println("After update");
        object.read(order.getID());
        object.delete(order);
    }
}
