package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.*;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdSignup extends Action {

    /**
     * creates entry in database table Users
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see User
     * @see by.it.rudzko._Project.java.DAO.UserDAO
     * @see Form
     */
    @Override
    Action execute(Form f) {
        User logged = (User) f.getSessionAttr(Messages.USER);
        if (logged != null) {
            return Actions.PROFILE.action;
        }
        if (f.isPost()) {
            User user = new User();
            try {
                DAO dao = DAO.getInst();
                String name = f.getParameter(Params.JSP_LOGIN, Patterns.LOGIN);

                //checks whether username is unique
                List<User> users = dao.userDao.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_NAME, name));
                if (users.isEmpty()) {
                    user.setName(name);
                    user.setPassword(f.getParameter(Params.JSP_PASSWORD, Patterns.PASSWORD));
                    user.setBirthYear(Integer.valueOf(f.getParameter(Params.BIRTH, Patterns.YEAR)));
                    if (Integer.valueOf(f.getParameter(Params.SEX)) == 1) {
                        user.setSex(Variables.M);
                    } else {
                        user.setSex(Variables.F);
                    }

                    //checks if table Role not empty, otherwise fill it with default roles: Administrator and Subscriber
                    List<Role> subscribers = dao.roleDao.getAll(SqlRequests.WHERE_ROLE_IS_SUBSCRIBER);
                    if (!subscribers.isEmpty()) {
                        user.setRole(subscribers.get(0));
                    } else {
                        List<Role> roles = dao.roleDao.getAll("");

                        //assigns the first user in database role Administrator
                        if (roles.isEmpty()) {
                            Role r = new Role(Variables.ADMINISTRATOR);
                            dao.roleDao.create(r);
                            user.setRole(r);
                        } else {
                            Role r = new Role(Variables.SUBSCRIBER);
                            dao.roleDao.create(r);
                            user.setRole(r);
                        }
                    }

                    //create entry in table Users
                    if (dao.userDao.create(user).equals(user)) {
                        return Actions.LOGIN.action;
                    } else {
                        f.setError(Messages.ERROR_DATABASE);
                    }
                } else {
                    f.setError(Messages.USER_EXISTS);
                }

            } catch (ParseException e) {
                f.setError(Messages.ERROR_DATA);
            }
        }
        return null;
    }
}
