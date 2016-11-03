package by.it.tsydzik.project.java.controller;

import by.it.tsydzik.project.java.beans.User;
import by.it.tsydzik.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public class CmdSignUp extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                //TODO тут добавлять свои beans (client) и к ним уже всё делать, а не user!!!!!!!!!!!!!!!!!!!
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                user.setEmail(Form.getParameter(req, "Email", Patterns.EMAIL));
                user.setFk_Role(2);
                DAO dao = DAO.getDAO();
                if (dao.client.create(user)) {
                    return Actions.LOGIN.action;
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, "Incorrect error");
                    return null;
                }
            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
