package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.Patterns;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdEditUsers extends Action {

    /**
     * updates username and role, removes user from table Users
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Form
     * @see User
     * @see by.it.rudzko._Project.java.DAO.UserDAO
     */
    @Override
    Action execute(Form f) {
        User user = (User) f.getSessionAttr(Messages.USER);
        int myId = user.getID();
        DAO dao = DAO.getInst();

        //creates list of administrators
        int adm = dao.roleDao.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ADMINISTRATOR)).get(0).getID();
        List<User> list = dao.userDao.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_ROLE, adm));
        List<String> admins = new ArrayList<>();
        for (User us : list) {
            if (us.getID() != myId) {
                admins.add(us.getName());
            } else {
                admins.add(Messages.YOU);
            }
        }

        //creates list of subscribers
        List<User> users = dao.userDao.getAll(String.format(Locale.ENGLISH, SqlRequests.WHERE_NOT_ROLE, adm));
        f.setReqAttr(Messages.FULLCAT, users);
        f.setReqAttr(Messages.ADMINS, admins);
        List<Role> roles = dao.roleDao.getAll("");
        f.setReqAttr(Messages.ROLES, roles);

        if (f.isPost()) {
            User updUser = dao.userDao.read(Integer.valueOf(f.getParameter(Params.OLD_USER)));

            //removes entry from table Users
            if (Integer.valueOf(f.getParameter(Params.ACTION_FOR_USER)) == 2) {
                if (dao.userDao.delete(updUser)) {
                    return Actions.EDITUSERS.action;
                } else {
                    f.setError(Messages.ERROR_DATABASE);
                }
            } else {

                //updates  entry in table Users
                try {
                    if (!f.getParameter(Params.NEW_USERNAME).isEmpty()) {
                        updUser.setName(f.getParameter(Params.NEW_USERNAME, Patterns.LOGIN));
                    }
                    Role r = dao.roleDao.read(Integer.valueOf(f.getParameter(Params.NEW_ROLE)));
                    updUser.setRole(r);
                    if (dao.userDao.update(updUser).equals(updUser)) {
                        return Actions.EDITUSERS.action;
                    } else {
                        f.setError(Messages.ERROR_DATABASE);
                    }
                } catch (ParseException e) {
                    f.setError(Messages.ERROR_DATA);
                }
            }
        }
        return null;
    }
}
