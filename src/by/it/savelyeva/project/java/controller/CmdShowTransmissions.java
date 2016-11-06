package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.Transmission;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowTransmissions extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<Transmission> types = dao.transmission.getAll("");
        req.setAttribute("types", types);
        return null;
    }
}
