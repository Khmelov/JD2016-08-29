package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.beans.User;
import by.it.senchenko.project.java.dao.SingletonDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        SingletonDAO dao=SingletonDAO.getSingletonDAO();
        List<User> users=dao.user.getAll("");
        req.setAttribute("users",users);
        return null;
    }
}
