package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowOrders extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao= DAO.getDAO();
        List<Orders> orders=dao.ordersDAO.getAll("");
        req.setAttribute("orders",orders);
        return null;
    }
}
