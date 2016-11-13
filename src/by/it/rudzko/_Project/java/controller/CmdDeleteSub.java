package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.Subscr;
import by.it.rudzko._Project.java.beans.User;

import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdDeleteSub extends Action {

    /**
     * removes entry from table Subscription
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Subscr
     * @see by.it.rudzko._Project.java.DAO.SubscrDAO
     * @see Form
     */
    @Override
    Action execute(Form f) {
        DAO dao = DAO.getInst();
        Periodical sub = (Periodical) f.getSessionAttr(Messages.DELETE_SUB);
        User user = (User) f.getSessionAttr(Messages.USER);
        if (f.isPost()) {
            Subscr removing = dao.subDao.getAll(String.format(Locale.ENGLISH,
                    SqlRequests.WHERE_SUBSCRIBER_AND_PERIODICAL, user.getID(), sub.getID())).get(0);
            if (dao.subDao.delete(removing)) {
                f.setSessionAttr(Messages.DELETE_SUB, null);
                return Actions.PROFILE.action;
            }
        }
        return null;
    }
}
