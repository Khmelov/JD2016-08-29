package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.Audience;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.Role;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdAdd extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getInst();
        List<Audience> aud = dao.audDao.getAll("");
        if (aud.isEmpty()) {
            Audience a1 = new Audience("Adult");
            aud.add(a1);
            dao.audDao.create(a1);
            Audience a2 = new Audience("Men");
            aud.add(a2);
            dao.audDao.create(a2);
            Audience a3 = new Audience("Women");
            aud.add(a3);
            dao.audDao.create(a3);
            Audience a4 = new Audience("Teens");
            aud.add(a4);
            dao.audDao.create(a4);
            Audience a5 = new Audience("Children");
            aud.add(a5);
            dao.audDao.create(a5);
        }
        StringBuilder readership = new StringBuilder();
        for (Audience aP : aud) {
            readership.append("<option value=\"").append(aP.getID()).append("\">").append(aP).append("</option>\n");
        }
        req.setAttribute("readership", readership);
        Form add = new Form(req);
        if (add.isPost()) {
            Periodical media = new Periodical();
            try {
                String title=add.getParameter("title", Patterns.TITLE);
                if (title.length()<20){
                media.setTitle(title);
                media.setSubIndex(Integer.valueOf(add.getParameter("index", Patterns.INDEX)));
                media.setAudience(dao.audDao.read(Integer.valueOf(req.getParameter("aud"))));
                media.setAddedBy((User) req.getSession().getAttribute("user"));
                if (dao.periDao.create(media).equals(media)) {
                    return Actions.CATALOGUE.action;
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, Messages.ERROR_DATABASE);
                }
            } else req.setAttribute(Messages.MESSAGE_ERROR, "Title length shoul be under 20 characters");
            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, Messages.ERROR_DATA);
            }
        }
        return null;
    }
}
