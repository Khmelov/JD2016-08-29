package by.it.rudzko._Project.java.controller;


import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Params;
import by.it.rudzko._Project.java.Strings.Patterns;
import by.it.rudzko._Project.java.beans.Audience;

import java.text.ParseException;
import java.util.List;

/**
 * @author Olga Rudzko
 */
class CmdEditReadership extends Action {

    /**
     * adds, updates and removes readership
     *
     * @param f contains servlet request and servlet response
     * @return next command for servlet
     * @see Form
     * @see Audience
     * @see by.it.rudzko._Project.java.DAO.AudienceDAO
     */
    @Override
    Action execute(Form f) {
        DAO dao = DAO.getInst();
        List<Audience> readership = dao.audDao.getAll("");
        f.setReqAttr(Messages.READERSHIP, readership);
        if (f.isPost()) {
            int aud = Integer.valueOf(f.getParameter(Params.OLD_READERSHIP));

            //creates entry in table Readership
            if (aud == 0) {
                if (Integer.valueOf(f.getParameter(Params.ACTION_FOR_READERSHIP)) == 1) {
                    if (!f.getParameter(Params.NEW_READERSHIP).isEmpty()) {
                        try {
                            Audience newAud = new Audience(f.getParameter(Params.NEW_READERSHIP, Patterns.AUDIENCE));
                            if (dao.audDao.create(newAud).equals(newAud)) {
                                return Actions.EDITREADERSHIP.action;
                            } else {
                                f.setError(Messages.ERROR_DATABASE);
                            }
                        } catch (ParseException e) {
                            f.setError(Messages.ERROR_DATA);
                        }
                    } else {
                        f.setError(Messages.ENTER_NAME_READERSHIP);
                    }
                } else {
                    f.setError(Messages.INVALID_OPERATION);
                }

                //removes entry from table Readership
            } else if (Integer.valueOf(f.getParameter(Params.ACTION_FOR_READERSHIP)) == 3) {
                if (dao.audDao.delete(dao.audDao.read(aud))) {
                    return Actions.EDITREADERSHIP.action;
                } else {
                    f.setError(Messages.ERROR_DATABASE);
                }
            } else {

                //updates entry in table Readership
                if (Integer.valueOf(f.getParameter(Params.ACTION_FOR_READERSHIP)) == 2) {
                    Audience a = dao.audDao.read(aud);
                    if (!f.getParameter(Params.NEW_READERSHIP).isEmpty()) {
                        try {
                            a.setGroup(f.getParameter(Params.NEW_READERSHIP, Patterns.AUDIENCE));
                            if (dao.audDao.update(a).equals(a)) {
                                return Actions.EDITREADERSHIP.action;
                            } else {
                                f.setError(Messages.ERROR_DATABASE);
                            }
                        } catch (ParseException e) {
                            f.setError(Messages.ERROR_DATA);
                        }
                    } else {
                        f.setError(Messages.ENTER_NAME_READERSHIP);
                    }
                } else {
                    f.setError(Messages.INVALID_OPERATION);
                }
            }
        }
        return null;
    }
}
