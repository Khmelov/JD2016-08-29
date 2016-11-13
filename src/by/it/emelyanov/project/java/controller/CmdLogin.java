package by.it.emelyanov.project.java.controller;


import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Users user = new Users();
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<Users> users = dao.usersDAO.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() == 1) {
                    //user ok. save to session
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    //cookie
                    Cookie userCookie = new Cookie("testCookie", "CookieValue");
                    userCookie.setMaxAge(30);
                    //get cookie
                    Cookie[] userCookies = req.getCookies();
                    String cookieName = "userCookie";
                    String cookieValue = "";
                    for(int i = 0; i < userCookies.length; i++) {
                        Cookie cookie = userCookies[i];
                        if (cookieName.equals(cookie.getName())){
                            cookieValue = cookie.getValue();
                            break;
                        }
                    }
                    session.setAttribute("cookie",cookieValue);

                    return Actions.PROFILE.action;
                } else {
                    Form.showError(req, "USER NOT FOUND");
                }
                ;
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
