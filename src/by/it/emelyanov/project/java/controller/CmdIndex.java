package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Orders;
import by.it.emelyanov.project.java.beans.Rooms;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Rooms> rooms=dao.roomsDAO.getAll("");
        req.setAttribute("rooms",rooms);
        return null;
    }
}
