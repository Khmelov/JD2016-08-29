package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.dao.SingletonDAO;
import by.it.senchenko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by User on 02.11.2016.
 */
public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            User user=new User();
            try {
                user.setLogin(Form.getParameter(req,"Login",Patterns.LOGIN));
                user.setLogin(Form.getParameter(req,"Passwor",Patterns.LOGIN));
                user.setLogin(Form.getParameter(req,"Email",Patterns.LOGIN));
                user.setFk_Role(2);
                SingletonDAO dao= SingletonDAO.getSingletonDAO();
                if (dao.user.create(user)){
                    req.setAttribute(Messages.MESSAGE_ERROR,"Database error");
                    return Actions.LOGIN.action;
                }
                return null;
            }catch (ParseException e){
                req.setAttribute(Messages.MESSAGE_ERROR,"Incorrect data");
                return null;
            }
        }
        return null;
    }
}
