package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            User user = new User();
            try {
                user.setLogin(Form.getParameter(req,"Login",Patterns.LOGIN));
                user.setPassword(Form.getParameter(req,"Password",Patterns.PASSWORD));
                user.setEmail(Form.getParameter(req,"Email",Patterns.EMAIL));
                user.setFk_role(2);
                SingletonDAO dao = SingletonDAO.getDAO();
                if (dao.user.create(user)){
                    return Actions.LOGIN.action;
                }
                else{
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
