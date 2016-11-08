package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.beans.User;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by nato on 11/5/16.
 */

public class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setId(Integer.parseInt(Form.getParameter(req, "id", IPattern.ID)));
                user.setLogin(Form.getParameter(req, "login", IPattern.LOGIN));
                user.setPassword(Form.getParameter(req, "password", IPattern.PASSWORD));
                user.setEmail(Form.getParameter(req, "email", IPattern.EMAIL));
                user.setIdRole(2);
                user.setFirstName(Form.getParameter(req, "firstName", IPattern.WORD));
                user.setLastName(Form.getParameter(req, "lastName", IPattern.WORD));
                user.setMiddleName(Form.getParameter(req, "middleName", IPattern.WORDOREMPTY));
                user.setDateOfBirth(Form.getParameter(req, "dateOfBirth", IPattern.DATE));
                user.setIdSex(Integer.parseInt(Form.getParameter(req, "idSex", IPattern.ID)));
                user.setPassport(Form.getParameter(req, "passport", IPattern.SERIAL));
                user.setIdAddress(Integer.parseInt(Form.getParameter(req, "idAddress", IPattern.ID)));
                user.setIdDriverLicense(Form.getParameter(req, "idDriverLicense", IPattern.SERIAL));
                DAO dao = DAO.getDAO();
                if (dao.user.update(user)){
                    return Actions.SUCCESS.action;
                }
                else
                {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        } else {
            DAO dao = DAO.getDAO();
            List<User> users = dao.user.getAll(" WHERE id=" + 7); //now it is taken as constant, should be taken from session
            req.setAttribute("user", users.get(0));
        }
        return null;
    }
}
