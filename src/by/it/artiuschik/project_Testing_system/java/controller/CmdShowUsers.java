package by.it.artiuschik.project_Testing_system.java.controller;

import by.it.artiuschik.project_Testing_system.java.beans.Role;
import by.it.artiuschik.project_Testing_system.java.beans.User;
import by.it.artiuschik.project_Testing_system.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdShowUsers extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        User user = (User) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getFK_ROLE() != 2) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                User userFromForm = new User();
                try {
                    userFromForm.setID(Form.getInt(req, "ID"));
                    userFromForm.setSurname(Form.getString(req, "Surname", Patterns.TEXT));
                    userFromForm.setName(Form.getString(req, "Name", Patterns.TEXT));
                    userFromForm.setBalls(Form.getInt(req, "Balls"));
                    userFromForm.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                    userFromForm.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                    userFromForm.setTests_amount(Form.getInt(req, "Tests"));
                    userFromForm.setFK_ROLE(Form.getInt(req, "fk_Role"));
                    if (userFromForm.getID() > 0) {
                        dao.user.update(userFromForm);
                    } else if (userFromForm.getID() == 0) {
                        dao.user.create(userFromForm);
                    } else {
                        userFromForm.setID(-1 * userFromForm.getID());
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
