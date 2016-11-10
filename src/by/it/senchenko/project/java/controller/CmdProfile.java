package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.beans.Periodicals;
import by.it.senchenko.project.java.beans.User;
import by.it.senchenko.project.java.dao.SingletonDAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


public class CmdProfile extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            try {
                String value=Form.getString(req,"LogoutButton","1");
                if (value.equals("1")){
                    req.getSession().invalidate();
                    return Actions.LOGIN.action;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        User user=(User)req.getSession().getAttribute("user");
        if (user!=null){
            List<Periodicals> periodicals= SingletonDAO.getSingletonDAO().periodicals.getAll(String.format(" where FK_Users='%d'",user.getId()));
            req.setAttribute("periodicals",periodicals);
        }

        return null;
    }
}
