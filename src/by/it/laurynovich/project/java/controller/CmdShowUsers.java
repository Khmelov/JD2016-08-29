package by.it.laurynovich.project.java.controller;

import by.it.laurynovich.project.java.beans.Role;
import by.it.laurynovich.project.java.beans.User;
import by.it.laurynovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        User user = (User) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getFk_Role() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                User userFromForm = new User();
                try {
                    userFromForm.setId(Form.getInt(req, "ID"));
                    userFromForm.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                    userFromForm.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                    userFromForm.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                    userFromForm.setFk_Role(Form.getInt(req, "fk_Role"));
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
            List<User> users = dao.user.getAll("");
            req.setAttribute("users", users);
            List<Role> roles = dao.role.getAll("");
            req.setAttribute("roles", roles);

        }


        return null;
    }
}
