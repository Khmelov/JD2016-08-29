package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Auto;
import by.it.grishechkin.project.java.beans.Order;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yury on 12.11.2016.
 */
public class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {

        try {
            User user = (User) req.getSession().getAttribute("user");
            List<Order> orders = DAO.getDAO().order.getAll(user.getID());
            List<Auto> autos = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++){
                Auto auto = new Auto();
                auto.setID(orders.get(i).getFK_Auto());
                autos.add(DAO.getDAO().auto.read(auto).get(0));
            }
            req.setAttribute("orders", orders);
            req.setAttribute("autos", autos);
        }
        catch (NullPointerException e) {
            return Actions.LOGIN.action;
        }
        return null;
    }
}
