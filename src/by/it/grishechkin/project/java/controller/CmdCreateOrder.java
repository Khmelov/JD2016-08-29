package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Auto;
import by.it.grishechkin.project.java.beans.Order;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yury on 12.11.2016.
 */
public class CmdCreateOrder extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user=(User)req.getSession().getAttribute("user");
        if (user==null)
            return Actions.LOGIN.action;
        if (Form.isPost(req)) {
            try {
                Auto auto = new Auto();
                auto.setID(Form.getInt(req, "autoID"));
                auto = DAO.getDAO().auto.read(auto).get(0);
                auto.setAvailability(0);
                DAO.getDAO().auto.update(auto);
                Order order = new Order();
                order.setTerm(Form.getInt(req, "Term"));
                order.setFK_Client(user.getID());
                order.setFK_Auto(auto.getID());
                order.setPay(0);
                order.setRefund(0);
                if (DAO.getDAO().order.create(order) != 0){
                    return Actions.PROFILE.action;
                }
                else {
                    Form.showError(req,"Database error");
                    return null;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<Auto> autos = DAO.getDAO().auto.getAll();
        req.setAttribute("autos", autos);
        return null;
    }
}
