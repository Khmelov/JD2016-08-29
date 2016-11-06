package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.dao.SingletonDAO;
import by.it.senchenko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            User user=new User();
            try {
                user.setLogin(Form.getParameter(req,"Login",Patterns.LOGIN));
                user.setLogin(Form.getParameter(req,"Password",Patterns.LOGIN));
                user.setLogin(Form.getParameter(req,"Email",Patterns.LOGIN));
                user.setFk_Role(2);
                SingletonDAO dao= SingletonDAO.getSingletonDAO();
                if (dao.user.create(user)){
                    return Actions.LOGIN.action;
                }else {
                    Form.showError(req,"Database error");
                    return null;
                }

            }catch (ParseException e){
                Form.showError(req,"Incorrect data");
                return null;
            }
        }
        return null;
    }
}
