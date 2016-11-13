package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdCreateOrder extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Orders order = new Orders();
            Users user = (Users) req.getSession().getAttribute("user");
            if (user == null) {
                Form.showMessage(req, "Необходимо авторизоваться");
                Form.showError(req, "Ошибка");
            } else {
                try {
                    order.setId(0);
                    order.setfK_User(user.getId());
                    order.setfK_Room(4);
                    order.setArrive_Date(Form.getString(req, "Arrive_Date", Patterns.DATE));
                    order.setReturn_Date(Form.getString(req, "Return_Date", Patterns.DATE));
                    order.setBill(Form.getFloat(req, "Bill", Patterns.MONEY));

                    DAO dao = DAO.getDAO();
                    if (dao.ordersDAO.create(order)) {
                        return Actions.INDEX.action;
                    } else {
                        Form.showError(req, "Database error");
                        return null;
                    }
                } catch (ParseException e) {
                    Form.showError(req, "Incorrect data");
                    return null;
                }
            }
        }
        return null;
    }
}
