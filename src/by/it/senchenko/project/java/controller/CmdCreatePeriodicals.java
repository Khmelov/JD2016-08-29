package by.it.senchenko.project.java.controller;

import by.it.senchenko.project.java.beans.Periodicals;
import by.it.senchenko.project.java.beans.User;
import by.it.senchenko.project.java.dao.SingletonDAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


public class CmdCreatePeriodicals extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user=(User) req.getSession().getAttribute("user");
        if (user==null){
            return Actions.LOGIN.action;
        }
        if (Form.isPost(req)){
            Periodicals periodical =new Periodicals();
            try {
                periodical.setName(Form.getString(req,"Name",".*"));
                periodical.setAutor(Form.getString(req,"Autor",".*"));
                periodical.setDate(Form.getString(req,"Date",".*"));
                periodical.setFK_User(user.getId());
                SingletonDAO.getSingletonDAO().periodicals.create(periodical);
                return Actions.INDEX.action;
            } catch (ParseException e) {
                return Actions.ERROR.action;
            }
        }
        return null;
    }
}
