package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.beans.Rent;
import by.it.savelyeva.project.java.beans.Sex;
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
        if (Form.isPost(req)) { // edit profile
            User user = new User();
            try {
                int id = ((User) req.getSession().getAttribute("user")).getId();
                user.setId(id);
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
                DAO dao = DAO.getDAO();
                if (dao.user.update(user)){
                    return Actions.SUCCESS.action;
                }
                else
                {
                    Form.showError(req, "Database error");
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
            }
            return Actions.ERROR.action;
        }
        else
        { // display profile
            User user = (User) req.getSession().getAttribute("user");
            DAO dao = DAO.getDAO();
            int startNumber;
            try {
                startNumber = Form.getInt(req,"startNumber");
            } catch (ParseException e) {
                startNumber = 0;
            }
            String limit = String.format("WHERE idUser=%d LIMIT %s,%s", user.getId(), startNumber, 5);
            List<Rent> rents = dao.rent.getAll(limit);
            int rentCount = dao.rent.getCount(String.format("WHERE idUser=%d", user.getId()));
            req.setAttribute("rentCount", rentCount);
            for (Rent rent : rents) {
                rent.setViewNumber(++startNumber);
            }

            req.setAttribute("user", user);
            List<Sex> sex = dao.sex.getAll("");
            req.setAttribute("sex", sex);

        }
        return null;
    }
}
