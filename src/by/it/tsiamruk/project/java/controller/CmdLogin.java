package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
                if (users.size() == 1){
                    //user ok.save to session
                    user = users.get(0);
                    HttpSession session =  req.getSession();
                    session.setAttribute("user", user);
                    Cookie cookie = new Cookie("user",user.toString());
                    cookie.setMaxAge(30);
                    return Actions.PROFILE.action;
                }
                else
                    Form.showError(req,"Database error");

            } catch (ParseException e) {
                Form.showError(req,"Incorrect data");
                return null;
            }
        }
        return null;
    }
}
