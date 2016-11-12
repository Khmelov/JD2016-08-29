package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.beans.Rooms;
import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowOrders extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getfK_Role() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                Orders orderFromForm = new Orders();
                try {
                    orderFromForm.setId(Form.getInt(req, "ID",Patterns.NUMB));
                    orderFromForm.setfK_User(Form.getInt(req, "fk_User",Patterns.NUMB));
                    orderFromForm.setfK_Room(Form.getInt(req,"fk_Room",Patterns.NUMB));
                    orderFromForm.setArrive_Date(Form.getString(req, "Arrive_Date", Patterns.DATE));
                    orderFromForm.setReturn_Date(Form.getString(req, "Return_Date",Patterns.DATE));
                    orderFromForm.setBill(Form.getFloat(req, "fk_Role", Patterns.MONEY));
                    if (orderFromForm.getId() > 0) {
                        dao.ordersDAO.update(orderFromForm);
                    } else if (orderFromForm.getId() == 0) {
                        dao.ordersDAO.create(orderFromForm);
                    } else {
                        orderFromForm.setId(-1 * orderFromForm.getId());
                        dao.ordersDAO.delete(orderFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            List<Users> users = dao.usersDAO.getAll("");
            req.setAttribute("users", users);
            List<Rooms> rooms = dao.roomsDAO.getAll("");
            req.setAttribute("rooms", rooms);
            List<Orders> orders = dao.ordersDAO.getAll("");
            req.setAttribute("orders", orders);
        }
        return null;
    }
}
