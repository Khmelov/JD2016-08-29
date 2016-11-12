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
        User user = new User();
        if (Form.isPost(req)) {
            try {
                user.setLogin(Form.getString(req, "Login", IPattern.LOGIN));
                user.setPassword(req.getParameter("Password"));
            } catch (Exception e) {
                Form.showMessage(req, "Неверные данные");
                Form.showError(req, "Ошибка");
                return null;
            }
            DAO dao = DAO.getDAO();
            List<User> users = dao.user.getAll(
                    String.format("WHERE Login='%s' AND Password='%s'",
                            user.getLogin(),
                            user.getPassword()
                    ));
            if (users.size() > 0) {
                user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                return Actions.PROFILE.action;
            }
            Form.showMessage(req, "Tакой пользователь не зарегистрирован");
            Form.showError(req, "Ошибка");
        }
        return null;
    }
}