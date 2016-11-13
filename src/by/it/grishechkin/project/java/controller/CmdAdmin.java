package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Auto;
import by.it.grishechkin.project.java.beans.Order;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Yury on 13.11.2016.
 */
public class CmdAdmin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        List<Auto> autos = DAO.getDAO().auto.getAll();
        req.setAttribute("autos", autos);
        List<Order> orders = DAO.getDAO().order.getAll();
        req.setAttribute("orders", orders);
        List<User> users = DAO.getDAO().user.getAll();
        req.setAttribute("users", users);
        if (Form.isPost(req)) {
            Order order = new Order();
            try {
                order.setID(Form.getInt(req, "orderID"));
                order = DAO.getDAO().order.read(order).get(0);
                order.setRefund(1);
                DAO.getDAO().order.update(order);
                for (Auto auto : autos) {
                    if (auto.getID() == order.getFK_Auto()) {
                        auto.setAvailability(1);
                        DAO.getDAO().auto.update(auto);
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
