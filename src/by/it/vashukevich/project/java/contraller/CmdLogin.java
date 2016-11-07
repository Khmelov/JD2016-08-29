package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
           Users users = new Users();
            try {
                users.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                users.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
               List<Users>user=dao.users.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                users.getLogin(),
                                users.getPassword()
                        ));
                if (user.size() == 1) {
                    //user ok. save to session
                    users=user.get(0);
                    HttpSession session=req.getSession();
                    session.setAttribute("user",users);
                    return Actions.PROFILE.action;
                } else {
                    Form.showError(req, "USER NOT FOUND");
                }

            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
