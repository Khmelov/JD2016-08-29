package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.DlCategory;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowDlCategories extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<DlCategory> dls = dao.dlCategory.getAll("");
        req.setAttribute("dls", dls);
        return null;
    }
}
