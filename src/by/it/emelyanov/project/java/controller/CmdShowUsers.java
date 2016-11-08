package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Users> users=dao.usersDAO.getAll("");
        req.setAttribute("users",users);
        return null;
    }
}
