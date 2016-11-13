package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.*;
import by.it.rudzko._Project.java.beans.User;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdLogin extends Action {

    /**
     * finds matches between input data and database table Users, starts session
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
            try {
                String uname = f.getParameter(Params.JSP_LOGIN, Patterns.LOGIN);
                String pass = f.getParameter(Params.JSP_PASSWORD, Patterns.PASSWORD);
                DAO dao = DAO.getInst();
                List<User> users = dao.userDao.getAll(String.format(Locale.ENGLISH,
                        SqlRequests.WHERE_NAME_PASSWORD, uname, pass));
                if (!users.isEmpty()) {
                    User user = users.get(0);
                    f.setSessionAttr(Messages.USER, user);

                    //sets list of recommended media instead of full catalogue
                    f.setSessionAttr(Messages.CATALOGUE, true);

                    f.setCookie(uname, pass);

                    //sets attribute for session context, needed for jsp script
                    if (f.admin(user)) {
                        f.setSessionAttr(Messages.ADMINISTRATOR, true);
                    }
                    return Actions.PROFILE.action;
                } else {
                    f.setError(Messages.USER_NOT_FOUND);
                }
            } catch (ParseException e) {
                f.setError(Messages.USER_NOT_FOUND);
            }
        }
        return null;
    }
}
