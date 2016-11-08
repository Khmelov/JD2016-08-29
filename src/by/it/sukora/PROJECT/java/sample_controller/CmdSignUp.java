package by.it.sukora.PROJECT.java.sample_controller;


import by.it.sukora.PROJECT.java.beans.*;
import by.it.sukora.PROJECT.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Sukora Stas.
 */
public class CmdSignUp extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Users user = new Users();
            try {
                user.setLastName(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setFirsName(Form.getParameter(req, "Password", Patterns.PASSWORD));
                user.setEmail(Form.getParameter(req, "Email", Patterns.EMAIL));
                user.setId_role(2);
                DAO dao = DAO.getDAO();
                if (dao.Users.create(user)) {
                    return Actions.LOGIN.action;
                } else {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
