package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

class CmdLogin extends Action {

    @Override
    Action execute(HttpServletRequest req) {

        Form login=new Form(req);
        if (login.isPost()) {
            try {
                String uname=login.getParameter("userlog", Patterns.LOGIN);
                String pass=login.getParameter("userpas", Patterns.PASSWORD);
                DAO dao = DAO.getInst();
                List<User> users = dao.userDao.getAll("WHERE Name='"+uname+"' and Password='"+pass+"'");
                if (!users.isEmpty()) {
                    User user=users.get(0);
                    HttpSession session=req.getSession();
                    session.setAttribute("user",user);
                    Cookie myCookie = new Cookie(uname, String.valueOf(pass.hashCode()));
                    myCookie.setMaxAge(30);
                    return Actions.PROFILE.action;
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, Messages.USER_NOT_FOUND);
                }
            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, Messages.USER_NOT_FOUND);
            }
        }
        return null;
    }
}
