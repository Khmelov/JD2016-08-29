package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Auto;
import by.it.grishechkin.project.java.beans.Order;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Yury on 10.11.2016.
 */
public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<User> users = dao.user.read(user);

                if (users.size() == 1) {
                    //user ok. save to session
                    if (users.get(0).getFK_Role() == 1) {
                        user = users.get(0);
                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);
                        return Actions.PROFILE.action;
                    }
                    else {
                        user = users.get(0);
                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);

                        return Actions.ADMIN.action;
                    }
                } else {
                    Form.showError(req, "USER NOT FOUND");
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        List<Auto> autos = DAO.getDAO().auto.getAll();
        req.setAttribute("autos", autos);
        return null;
    }
}
