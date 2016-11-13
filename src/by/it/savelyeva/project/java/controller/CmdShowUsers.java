package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.Role;
import by.it.savelyeva.project.java.beans.Sex;
import by.it.savelyeva.project.java.beans.User;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
            return Actions.LOGIN.action;
        }
        if (user.getIdRole() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        }
        else
        {
            DAO dao = DAO.getDAO();
            if (Form.isPost(req)) {
                User userFromForm = new User();
                try {
                    userFromForm.setId(Form.getInt(req, "id"));
                    userFromForm.setLogin(Form.getString(req, "login", IPattern.LOGIN));
                    userFromForm.setPassword(Form.getString(req, "password", IPattern.PASSWORD));
                    userFromForm.setEmail(Form.getString(req, "email", IPattern.EMAIL));
                    userFromForm.setIdRole(Form.getInt(req, "idRole"));
                    userFromForm.setFirstName(Form.getString(req, "firstName", IPattern.WORD));
                    userFromForm.setLastName(Form.getString(req, "lastName", IPattern.WORD));
                    userFromForm.setMiddleName(Form.getString(req, "middleName", IPattern.WORDOREMPTY));
                    userFromForm.setDateOfBirth(Form.getString(req, "dateOfBirth", IPattern.DATE));
                    userFromForm.setIdSex(Form.getInt(req, "idSex"));
                    userFromForm.setPassport(Form.getString(req, "passport", IPattern.SERIAL));
                    userFromForm.setIdAddress(Form.getInt(req, "idAddress"));
                    userFromForm.setIdDriverLicense(Form.getString(req, "idDriverLicense", IPattern.SERIAL));

                    if (userFromForm.getId() > 0) {
                        dao.user.update(userFromForm);
                    } else if (userFromForm.getId() == 0) {
                        dao.user.create(userFromForm);
                    } else {
                        userFromForm.setId(-1 * userFromForm.getId());
                        dao.user.delete(userFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            req.setAttribute("usersCount", dao.user.getCount(""));
            List<User> users = dao.user.getAll("");
            req.setAttribute("users", users);
            List<Role> roles = dao.role.getAll("");
            req.setAttribute("roles", roles);
            List<Sex> sex = dao.sex.getAll("");
            req.setAttribute("sex", sex);
        }


        return null;
    }
}
