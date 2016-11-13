package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setSurname(Form.getParameter(req, "Surname", Patterns.TEXT));
                user.setName(Form.getParameter(req, "Name", Patterns.TEXT));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setTests_amount(0);
                user.setBalls(0);
                String value = Form.getParameter(req, "Role", "[1-2]");
                if (value.equals("1")) {
                    user.setFK_ROLE(1);
                } else {
                    user.setFK_ROLE(2);
                }

                DAO dao = DAO.getDAO();
                if (dao.user.create(user)) {
                    return Actions.LOGIN.action;
                } else {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data"+user);
                return null;
            }
        }
        return null;
    }
}
