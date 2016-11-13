package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Order;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Yury on 13.11.2016.
 */
public class CmdDeleteOrder extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Order order = new Order();
            try {
                order.setID(Form.getInt(req, "orderID"));
                DAO.getDAO().order.delete(order);
                return Actions.PROFILE.action;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
