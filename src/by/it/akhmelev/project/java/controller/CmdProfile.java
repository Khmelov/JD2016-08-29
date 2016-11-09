package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Action {
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
            List<Ad> ads= DAO.getDAO().ad.getAll(String.format(" where FK_Users='%d'",user.getId()));
            req.setAttribute("ads",ads);
        }

        return null;
    }
}
