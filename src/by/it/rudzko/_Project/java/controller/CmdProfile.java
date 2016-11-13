package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.User;
import by.it.rudzko._Project.java.beans.Subscr;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdProfile extends Action {

    /**
     * reads list of user's subscriptions from  table Subscription, closes session
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Subscr
     * @see by.it.rudzko._Project.java.DAO.SubscrDAO
     * @see Form
     */
    @Override
    Action execute(Form f) {
        User user = (User) f.getSessionAttr(Messages.USER);
        if (user == null) {
            return Actions.INDEX.action;
        }
        DAO dao = DAO.getInst();
        List<Subscr> subscription = dao.subDao.getAll(String.format(Locale.ENGLISH,
                SqlRequests.WHERE_SUBSCRIBER, user.getID()));
        List<Periodical> subscrs = new ArrayList<>();

        if (!f.admin(user)) {
            f.setReqAttr(Messages.MY_ADDS, subscription.size());

            //gets list of periodicals which this subscriber is subscribed to
            for (Subscr sub : subscription) {
                subscrs.add(sub.getPeriodical());
            }
            f.setReqAttr(Messages.SUBSCRIPTION, subscrs);
        } else {

            //gets list of periodicals which this administrator has added
            List<Periodical> myAddedPeri = dao.periDao.getAll
                    (String.format(Locale.ENGLISH, SqlRequests.WHERE_ADDED, user.getID()));
            f.setReqAttr(Messages.MY_ADDS, myAddedPeri.size());
        }

        if (f.isPost()) {
            if (!f.admin(user)) {
                int param = Integer.valueOf(f.getParameter(Params.SUBSCRIPTION));

                //redirects to another page to remove selected media from user's subscription
                if (f.getParameter(Params.DELETE_BUTTON) != null) {
                    Periodical p = dao.periDao.read(param);
                    f.setSessionAttr(Messages.DELETE_SUB, p);
                    return Actions.DELETESUB.action;
                }
            }
            //closes session
            if (f.getParameter(Params.JSP_LOGOUT) != null) {
                f.getReq().getSession().invalidate();
                return Actions.LOGIN.action;
            }
        }
        return null;
    }
}
