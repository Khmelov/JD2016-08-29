package by.it.senchenko.project.java.controller;


import by.it.senchenko.project.java.beans.Periodicals;
import by.it.senchenko.project.java.dao.SingletonDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        SingletonDAO dao=SingletonDAO.getSingletonDAO();
        List<Periodicals> periodical=dao.periodicals.getAll("");
        req.setAttribute("periodical",periodical);
        return null;
    }
}
