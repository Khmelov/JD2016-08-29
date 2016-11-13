package by.it.sukora.PROJECT.java.sample_controller;

import by.it.sukora.PROJECT.java.beans.logpas;
import by.it.sukora.PROJECT.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            logpas user = new logpas();
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(req.getParameter("Password"));
            } catch (Exception e) {
                Form.showMessage(req, "Неверные данные");
                Form.showError(req, "Ошибка");

                return null;
            }
                DAO dao = DAO.getDAO();
                List<logpas> users = dao.logpas.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,5",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() > 0) {
                    //users ok. save to session
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
