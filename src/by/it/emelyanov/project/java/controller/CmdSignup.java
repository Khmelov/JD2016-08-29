package by.it.emelyanov.project.java.controller;


import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Users user=new Users();
            try {
                user.setLogin(Form.getString(req,"Login",Patterns.LOGIN));
                user.setPassword(Form.getString(req,"Password",Patterns.PASSWORD));
                user.setEmail(Form.getString(req,"Email",Patterns.EMAIL));
                user.setfK_Role(2);

                DAO dao=DAO.getDAO();
                if (dao.usersDAO.create(user)){
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
