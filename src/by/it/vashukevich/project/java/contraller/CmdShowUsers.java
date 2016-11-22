package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Role;
import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowUsers extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getRole() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                Users userFromForm = new Users();
                try {
                    userFromForm.setId(Form.getInt(req, "Id"));
                    userFromForm.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                    userFromForm.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                    userFromForm.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
                    userFromForm.setRole(Form.getInt(req, "Role"));
                    if (userFromForm.getId() > 0) {
                        dao.users.update(userFromForm);
                    } else if (userFromForm.getId() == 0) {
                        dao.users.create(userFromForm);
                    } else {
                        userFromForm.setId(-1 * userFromForm.getId());
                        dao.users.delete(userFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            List<Users> users = dao.users.getAll("");
            req.setAttribute("users", users);
            List<Role> roles = dao.role.getAll("");
            req.setAttribute("roles", roles);

        }
        return null;
    }

   // public static void main(String[] args) {
       // System.out.println(DAO.getDAO().users.getAll(""));
   // }
}
