package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Yury on 12.11.2016.
 */
public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setFirstName(Form.getString(req, "firstName", Patterns.LOGIN));
                user.setLastName(Form.getString(req, "lastName", Patterns.LOGIN));
                user.setPasportNum(Form.getString(req, "pasportNumber", Patterns.LOGIN));
                user.setLogin(Form.getString(req, "login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                user.setFK_Role(1);
                if (dao.user.create(user) != 0) {
                    return Actions.LOGIN.action;
                }
                else {
                    Form.showError(req,"Database error");
                    return null;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
