package by.it.artiuschik.project_Testing_system.java.controller;

import by.it.artiuschik.project_Testing_system.java.beans.Test;
import by.it.artiuschik.project_Testing_system.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Test> tests=dao.test.getAll("");
        req.setAttribute("tests",tests);
        return null;
    }
}
