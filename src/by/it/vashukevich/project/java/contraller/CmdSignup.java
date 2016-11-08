package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Users users=new Users();
            try {
                users.setLogin(Form.getParameter(req,"Login",Patterns.LOGIN));
                users.setPassword(Form.getParameter(req,"Password",Patterns.PASSWORD));
                users.setEmail(Form.getParameter(req,"Email",Patterns.EMAIL));
                users.setRole(2);
                DAO dao=DAO.getDAO();
                if (dao.users.create(users)){
                    return Actions.LOGIN.action;
                }
                else
                {
                    Form.showError(req,"Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req,"Incorrect data");
                return null;
            }
        }
        return null;
    }
}
