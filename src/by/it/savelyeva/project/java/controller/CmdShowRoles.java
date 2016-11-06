package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.Role;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowRoles extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<Role> roles = dao.role.getAll("");
        //if (roles.size() >=1) req.setAttribute("roles", "FOUND!");
        //else req.setAttribute("roles", "NOT FOUND!");
        req.setAttribute("roles", roles);
        return null;
    }
}
