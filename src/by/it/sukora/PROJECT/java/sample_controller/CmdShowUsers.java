package by.it.sukora.PROJECT.java.sample_controller;

import by.it.sukora.PROJECT.java.beans.Role;
import by.it.sukora.PROJECT.java.beans.Users;
import by.it.sukora.PROJECT.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();


        List<Users> users = dao.Users.getAll("");
        req.setAttribute("users", users);
        List<Role> roles = dao.Role.getAll("");
        req.setAttribute("roles", roles);
        return null;
    }
}
