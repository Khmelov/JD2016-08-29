package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.beans.User;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * Created by nato on 11/2/16.
 */
public class CmdLogin extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(Form.getParameter(req, "Login", IPattern.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", IPattern.PASSWORD));
                DAO dao = DAO.getDAO();
                List<User> users = dao.user.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() == 1) {
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    return Actions.PROFILE.action;
                } else {
                    Form.showError(req, "USER NOT FOUND");
                }
                ;
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}