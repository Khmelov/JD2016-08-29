package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.beans.User;
import by.it.senchenko.project.java.dao.SingletonDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;


public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                SingletonDAO dao = SingletonDAO.getSingletonDAO();
                List<User> users = dao.user.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() == 1) {
                    user=users.get(0);
                    HttpSession session=req.getSession();
                    session.setAttribute("user",user);
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
