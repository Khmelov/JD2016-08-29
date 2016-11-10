package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            try {
                String value=Form.getString(req,"LogoutButton","1");
                if (value.equals("1")){
                    req.getSession().invalidate();
                   return Actions.INDEX.action;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Users user=(Users)req.getSession().getAttribute("user");
        if (user!=null){
            List<Orders> orders= DAO.getDAO().ordersDAO.getAll(String.format(" where FK_User='%d'",user.getId()));
            req.setAttribute("orders",orders);
        }

        return null;
    }
}
