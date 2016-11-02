package by.it.tsydzik.project.java.controller;

import by.it.tsydzik.jd03_03.beans.Client;
import by.it.tsydzik.project.java.beans.User;
import by.it.tsydzik.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                //TODO тут добавлять свои beans (client) и к ним уже всё делать, а не user!!!!!!!!!!!!!!!!!!!
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                user.setFk_Role(2);
                DAO dao = DAO.getDAO();
                List<Client> users = dao.client.getAll(String.format("WHERE Login='%s' and Password='%s'",
                        user.getLogin(),
                        user.getPassword()
                ));
                if (users.size() == 1) {
                    return Actions.LOGOUT.action;
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, "USER not found");
                }
            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
