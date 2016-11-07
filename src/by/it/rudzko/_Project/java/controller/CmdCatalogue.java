package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.Subscr;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdCatalogue extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        User logged = (User) req.getSession().getAttribute("user");
        if (logged == null) {
            req.setAttribute(Messages.MESSAGE_ERROR, "Please log in or register to subscribe.");
        }
        DAO dao = DAO.getInst();
        List<Periodical> p = dao.periDao.getAll("");
        StringBuilder periodicals = new StringBuilder();
        for (Periodical aP : p) {
            periodicals.append(Messages.OPTION_START).append(aP.getID()).append("\">").append(aP).append(Messages.OPTION_END);
        }
        req.setAttribute("periodicals", periodicals);
        Form cat = new Form(req);
        if (cat.isPost()) {
            if (logged != null) {
                Subscr sub = new Subscr();
                User user = (User) req.getSession().getAttribute("user");
                sub.setSubscriber(user);
                if(req.getParameter("cat")!=null){
                    int perId = Integer.valueOf(req.getParameter("cat"));
                List<Subscr> list = dao.subDao.getAll("WHERE FK_Subscriber=" + user.getID() + " and FK_Periodical=" + perId);
                if (list.isEmpty()) {
                    sub.setPeriodical(dao.periDao.read(perId));
                    if (dao.subDao.create(sub).equals(sub)) {
                        return Actions.PROFILE.action;
                    } else {
                        req.setAttribute(Messages.MESSAGE_ERROR, Messages.CANT_SUBSCRIBE);
                    }
                } else {
                    req.setAttribute(Messages.MESSAGE_ERROR, Messages.SUBSCRIBED);
                }
            }else
                req.setAttribute(Messages.MESSAGE_ERROR, Messages.CHOOSE_MEDIA);
            } else {
                return Actions.INDEX.action;
            }
        }
        return null;
    }
}
