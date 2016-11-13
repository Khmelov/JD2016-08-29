package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.SqlRequests;
import by.it.rudzko._Project.java.Strings.Variables;
import by.it.rudzko._Project.java.beans.Audience;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.Subscr;
import by.it.rudzko._Project.java.beans.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Olga Rudzko
 */
class CmdCatalogue extends Action {

    /**
     * forms view of catalogue for different users
     * creates entry in database table Subscription
     * deletes entry from table Periodicals
     * redirects to update entry from table Periodical
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Subscr
     * @see by.it.rudzko._Project.java.DAO.PeriodicalDAO
     * @see by.it.rudzko._Project.java.DAO.SubscrDAO
     * @see Form
     */
    @Override
    Action execute(Form f) {
        User logged = (User) f.getSessionAttr(Messages.USER);
        DAO dao = DAO.getInst();

        List<Periodical> allPeri = dao.periDao.getAll("");
        List<Periodical> recommend = new ArrayList<>();

        if (logged == null) {
            f.setReqAttr(Messages.MESSAGE, Messages.LOG_IN_OR_REGISTER);
            f.setReqAttr(Messages.PERIODICALS, allPeri);
        }

        //checks whether user is not an administrator
        else if (!(f.admin(logged))) {

            //prepares basic for jumping between full catalogue and recommended media
            if ((boolean) f.getSessionAttr(Messages.CATALOGUE)) {
                f.setSessionAttr(Messages.CATALOGUE, false);
            } else {
                f.setSessionAttr(Messages.CATALOGUE, true);
            }

            //calculates subscriber's age
            int age = f.getCurYear() - logged.getBirthYear();

            //finds and adds to list of recommendations all medias which match sex and age of subscriber
            List<Audience> readership = dao.audDao.getAll("");
            int adults = 0;
            int men = 0;
            int women = 0;
            int teens = 0;
            int children = 0;
            for (Audience aud : readership) {
                switch (aud.getGroup()) {
                    case Variables.ADULTS:
                        adults = aud.getID();
                        break;
                    case Variables.MEN:
                        men = aud.getID();
                        break;
                    case Variables.WOMEN:
                        women = aud.getID();
                        break;
                    case Variables.TEENS:
                        teens = aud.getID();
                        break;
                    case Variables.CHILDREN:
                        children = aud.getID();
                        break;
                    default:

                        //informs administrators that new readerships available
                        f.getReq().getSession().getServletContext().setAttribute
                                (Messages.READERSHIP_CHANGED, Messages.TABLE_READERSHIP_HAS_BEEN_CHANGED);
                }
            }
            if (age > 18) {
                recommend.addAll(dao.periDao.getAll(String.format
                        (Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, adults)));
                if (logged.getSex().equalsIgnoreCase(Variables.F)) {
                    recommend.addAll(0, dao.periDao.getAll
                            (String.format(Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, women)));
                } else {
                    recommend.addAll(0, dao.periDao.getAll
                            (String.format(Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, men)));
                }
            } else if (age > 12) {
                recommend.addAll(dao.periDao.getAll
                        (String.format(Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, teens)));
            } else {
                recommend.addAll(dao.periDao.getAll
                        (String.format(Locale.ENGLISH, SqlRequests.WHERE_READERSHIP, children)));
            }

            //forms full catalogue and list of recommended medias
            if ((boolean) f.getSessionAttr(Messages.CATALOGUE)) {
                f.setReqAttr(Messages.PERIODICALS, allPeri);
                f.setReqAttr(Messages.FULLCAT, Messages.FULL_CAT_LABEL);
                f.setReqAttr(Messages.CHANGE_VIEW, Messages.SHOW_RECOMMENDED);
            } else {
                f.setReqAttr(Messages.PERIODICALS, recommend);
                f.setReqAttr(Messages.FULLCAT, Messages.RECOMMENDED_LABEL);
                f.setReqAttr(Messages.CHANGE_VIEW, Messages.SHOW_FULL_CATALOGUE);
            }
        } else {

            //if user is administrator
            List<Periodical> myAddedPeri = dao.periDao.getAll
                    (String.format(Locale.ENGLISH, SqlRequests.WHERE_ADDED, logged.getID()));
            f.setReqAttr(Messages.PERIODICALS, myAddedPeri);
            f.setReqAttr(Messages.CHANGE_VIEW, Messages.ADD_NEW_MEDIA_LINK);
        }

        if (f.isPost()) {
            if (!f.admin(logged)) {
                Subscr sub = new Subscr();
                User user = (User) f.getSessionAttr(Messages.USER);
                sub.setSubscriber(user);
                if (f.getParameter(Params.JSP_CAT) != null) {

                    //gets name of chosen periodical and checks whether this user not subscribed to it
                    int perId = Integer.valueOf(f.getParameter(Params.JSP_CAT));
                    List<Subscr> list = dao.subDao.getAll(String.format(Locale.ENGLISH,
                            SqlRequests.WHERE_SUBSCRIBER_AND_PERIODICAL, user.getID(), perId));
                    if (list.isEmpty()) {
                        sub.setPeriodical(dao.periDao.read(perId));

                        //creates an entry in table Subscription
                        if (dao.subDao.create(sub).equals(sub)) {
                            return Actions.PROFILE.action;
                        } else {
                            f.setError(Messages.ERROR_DATABASE);
                        }
                    } else {
                        f.setError(Messages.SUBSCRIBED);
                    }
                } else
                    f.setError(Messages.CHOOSE_MEDIA);
            } else {

                //actions for administrator
                if (f.getParameter(Params.JSP_CAT) != null) {
                    int id = Integer.valueOf(f.getParameter(Params.JSP_CAT));
                    Periodical p = dao.periDao.read(id);
                    if (Integer.valueOf(f.getParameter(Params.CHANGE)) == 2) {

                        //removes media
                        if (dao.periDao.delete(p)) {
                            return Actions.CATALOGUE.action;
                        } else {
                            f.setError(Messages.ERROR_DATABASE);
                        }
                    } else {

                        //redirects to update media
                        f.setSessionAttr(Messages.UPDATE_MEDIA, p);
                        return Actions.ADD.action;
                    }
                } else
                    f.setError(Messages.CHOOSE_MEDIA);
            }
        }
        return null;
    }

}
