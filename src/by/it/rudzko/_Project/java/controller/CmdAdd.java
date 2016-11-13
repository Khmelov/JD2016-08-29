package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.Patterns;
import by.it.rudzko._Project.java.Strings.Variables;
import by.it.rudzko._Project.java.beans.Audience;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.User;

import java.text.ParseException;
import java.util.List;

/**
 * @author Olga Rudzko
 */
class CmdAdd extends Action {

    /**
     * adds periodical to table Periodical
     * updates periodical in table Periodical
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Periodical
     * @see Form
     */
    @Override
    Action execute(Form f) {
        DAO dao = DAO.getInst();
        List<Audience> aud = dao.audDao.getAll("");
        Object obj = f.getSessionAttr(Messages.UPDATE_MEDIA);
        if (obj != null) {
            f.setReqAttr(Messages.MESSAGE, Messages.UPDATING + obj);
        }

        //fills table Readership if database is empty
        if (aud.isEmpty()) {
            Audience a1 = new Audience(Variables.ADULTS);
            aud.add(a1);
            dao.audDao.create(a1);
            Audience a2 = new Audience(Variables.MEN);
            aud.add(a2);
            dao.audDao.create(a2);
            Audience a3 = new Audience(Variables.WOMEN);
            aud.add(a3);
            dao.audDao.create(a3);
            Audience a4 = new Audience(Variables.TEENS);
            aud.add(a4);
            dao.audDao.create(a4);
            Audience a5 = new Audience(Variables.CHILDREN);
            aud.add(a5);
            dao.audDao.create(a5);
        }

        f.setReqAttr(Messages.READERSHIP, aud);

        if (f.isPost()) {
            Periodical media;
            if (obj == null) {
                media = new Periodical();
            } else {
                media = (Periodical) obj;
            }
            try {
                String title = f.getParameter(Params.JSP_TITLE, Patterns.TITLE);
                media.setTitle(title);
                media.setSubIndex(Integer.valueOf(f.getParameter(Params.JSP_INDEX, Patterns.INDEX)));
                media.setAudience(dao.audDao.read(Integer.valueOf(f.getParameter(Params.JSP_AUD))));
                media.setAddedBy((User) f.getSessionAttr(Params.JSP_USER));

                //creates an entry in database table Periodicals
                if (obj == null) {
                    if (dao.periDao.create(media).equals(media)) {
                        return Actions.CATALOGUE.action;
                    } else {
                        f.setError(Messages.ERROR_DATABASE);
                    }
                } else {

                    //updates an entry in database table Periodicals
                    if (dao.periDao.update(media).equals(media)) {
                        f.setSessionAttr(Messages.UPDATE_MEDIA, null);
                        return Actions.CATALOGUE.action;
                    } else {
                        f.setError(Messages.ERROR_DATABASE);
                    }
                }
            } catch (ParseException e) {
                f.setError(Messages.ERROR_DATA);
            }
        }
        return null;
    }
}
