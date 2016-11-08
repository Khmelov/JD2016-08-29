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
                user.setLogin(Form.getParameter(req, "login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<logpas> users = dao.logpas.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() == 1) {
                    //users ok. save to session

                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    return Actions.PROFILE.action;

                } else {
                    Form.showError(req, "USER NOT FOUND");
                }

            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
