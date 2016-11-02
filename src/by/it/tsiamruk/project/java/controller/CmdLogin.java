package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdLogin extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            User user = new User();
            try{
                user.setLogin(Form.getParameter(req,"Login",Patterns.LOGIN));
                user.setPassword(Form.getParameter(req,"Password",Patterns.PASSWORD));
                SingletonDAO dao = SingletonDAO.getDAO();
                List<User> users = dao.user.getAll(String.format("WHERE login = '%s' and password = '%s' LIMIT 0,1",
                        user.getLogin(),user.getPassword()));
                if (users.size() == 1)
                    return Actions.CREATEACCOUNT.action;
                else
                    req.setAttribute(Messages.MESSAGE_ERROR,"USER NOT FOUND");


            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
