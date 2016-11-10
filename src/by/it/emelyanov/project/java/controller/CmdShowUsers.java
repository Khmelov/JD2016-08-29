package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getfK_Role() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                Users userFromForm = new Users();
                try {
                    userFromForm.setId(Form.getInt(req, "ID",Patterns.NUMB));
                    userFromForm.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                    userFromForm.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                    userFromForm.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                    userFromForm.setfK_Role(Form.getInt(req, "fk_Role",Patterns.NUMB));
                    if (userFromForm.getId() > 0) {
                        dao.usersDAO.update(userFromForm);
                    } else if (userFromForm.getId() == 0) {
                        dao.usersDAO.create(userFromForm);
                    } else {
                        userFromForm.setId(-1 * userFromForm.getId());
                        dao.usersDAO.delete(userFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            List<Users> users = dao.usersDAO.getAll("");
            req.setAttribute("users", users);


        }


        return null;
    }
}
