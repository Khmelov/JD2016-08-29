package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.dao.DAO;
import by.it.savelyeva.project.java.beans.User;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by nato on 11/2/16.
 */

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        if (Form.isPost(req)) {
            try {
                user.setId(0);
                user.setLogin(Form.getString(req, "login", IPattern.LOGIN));
                user.setPassword(Form.getString(req, "password", IPattern.PASSWORD));
                user.setEmail(Form.getString(req, "email", IPattern.EMAIL));
                user.setIdRole(2);
                user.setFirstName(Form.getString(req, "firstName", IPattern.WORD));
                user.setLastName(Form.getString(req, "lastName", IPattern.WORD));
                user.setMiddleName(Form.getString(req, "middleName", IPattern.WORDOREMPTY));
                user.setDateOfBirth(Form.getString(req, "dateOfBirth", IPattern.DATE));
                user.setIdSex(Form.getInt(req, "idSex"));
                user.setPassport(Form.getString(req, "passport", IPattern.SERIAL));
                user.setIdAddress(Form.getInt(req, "idAddress"));
                user.setIdDriverLicense(Form.getString(req, "idDriverLicense", IPattern.SERIAL));
            } catch (Exception e) {
                req.setAttribute(Messages.MESSAGE_ERROR, "Invalid data");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                req.setAttribute(Messages.MESSAGE, "User has been registered successfully");
                return Actions.LOGIN.action;
            } else {
                req.setAttribute(Messages.MESSAGE_ERROR, "User has not been created");
            }
        }
        return null;
    }
}
