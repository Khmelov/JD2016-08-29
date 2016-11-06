package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.Color;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowColors extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<Color> colors = dao.color.getAll("");
        req.setAttribute("colors", colors);
        return null;
    }
}
