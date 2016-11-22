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
            Users user = new Users();
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<Users> userses = dao.users.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (userses.size() == 1) {
                    //user ok. save to session
                    user=userses.get(0);
                    HttpSession session=req.getSession();
                    session.setAttribute("user",user);
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
