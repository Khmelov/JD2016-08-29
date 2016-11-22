package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<User> users = dao.user.getAll(user.getLogin(),user.getPassword());
                if (users.size() == 1) {
                    //user ok. save to session
                    user=users.get(0);
                    req.getSession().setAttribute("user",user);
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
