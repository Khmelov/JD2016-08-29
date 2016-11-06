package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdSignup extends Action {

    @Override
    Action execute(HttpServletRequest req) {

        Form register = new Form(req);

        if (register.isPost()) {
            User user = new User();
            try {
                DAO dao = DAO.getInst();
                String name = register.getParameter("username", Patterns.LOGIN);
                List<User> users = dao.userDao.getAll("WHERE Name='" + name + "'");
                if (users.isEmpty()) {
                    user.setName(name);
                    user.setPassword(register.getParameter("password", Patterns.PASSWORD));
                    user.setBirthYear(Integer.valueOf(register.getParameter("birth", Patterns.YEAR)));
                    if (Integer.valueOf(req.getParameter("sex")) == 1) {
                        user.setSex("M");
                    } else {
                        user.setSex("F");
                    }
                    List<Role> roles = dao.roleDao.getAll("WHERE Role='Subscriber'");
                    if (!roles.isEmpty()) {
                        user.setRole(roles.get(0));
                    } else {
                        Role r = new Role("Subscriber");
                        dao.roleDao.create(r);
                        user.setRole(r);
                    }
                    if (dao.userDao.create(user).equals(user)) {
                        return Actions.LOGIN.action;
                    } else {
                        req.setAttribute(Messages.MESSAGE_ERROR, Messages.ERROR_DATABASE_CANT_ADD_USER);
                    }
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, Messages.USER_EXISTS);
                }

            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, Messages.USER_EXISTS);
            }
        }
        return null;
    }
}
