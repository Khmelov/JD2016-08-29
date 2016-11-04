package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<User> users=dao.user.getAll("");
        req.setAttribute("users",users);
        return null;
    }
}
