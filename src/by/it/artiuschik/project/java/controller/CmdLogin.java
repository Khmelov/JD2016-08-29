package by.it.artiuschik.project.java.controller;


import by.it.artiuschik.project.java.beans.User;
import by.it.artiuschik.project.java.dao.DAO;
import by.it.artiuschik.project.java.shifr.EncoderDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            User user = new User();
            try {
                user.setLogin(Form.getParameter(req, "Login", Patterns.LOGIN));
                user.setPassword(Form.getParameter(req, "Password", Patterns.PASSWORD));
                DAO dao = DAO.getDAO();
                List<User> users = dao.user.getAll(
                        String.format("WHERE Login='%s' and Password='%s' LIMIT 0,1",
                                user.getLogin(),
                                user.getPassword()
                        ));
                if (users.size() == 1) {
                    //user ok. save to session
                    user=users.get(0);
                    String login=user.getLogin();
                    String password=new String(EncoderDecoder.encode(user.getPassword(),"abcd"));
                    HttpSession session=req.getSession();
                    session.setAttribute("Login", login);
                    session.setAttribute("Password",password);
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
