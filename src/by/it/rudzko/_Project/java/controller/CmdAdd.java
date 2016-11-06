package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.Audience;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdAdd extends Action{

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getInst();
        List<Audience> p=dao.audDao.getAll("");
        StringBuilder readership=new StringBuilder();
        for (Audience aP : p) {
            readership.append("<option value=\"").append(aP.getID()).append("\">").append(aP).append("</option>\n");
        }
        req.setAttribute("readership",readership);
        Form add=new Form(req);
        if(add.isPost()){
            Periodical media=new Periodical();
            try {
                media.setTitle(add.getParameter("title", Patterns.TITLE));
                media.setSubIndex(Integer.valueOf(add.getParameter("index", Patterns.INDEX)));
                media.setAudience(dao.audDao.read(Integer.valueOf(req.getParameter("aud"))));
                media.setAddedBy((User)req.getSession().getAttribute("user"));
                if(dao.periDao.create(media).equals(media)){
                    return Actions.CATALOGUE.action;
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, Messages.ERROR_DATABASE_CANT_ADD_PERI);
                }
            } catch (ParseException e) {
                req.setAttribute(Messages.MESSAGE_ERROR, Messages.ERROR_DATA);
            }
        }
        return null;
    }
}
