package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DAO.DAO;
import by.it.rudzko._Project.java.beans.Periodical;
import by.it.rudzko._Project.java.beans.User;
import by.it.rudzko._Project.java.beans.Subscr;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

 class CmdProfile extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        Form profile = new Form(req);
        User user=(User)req.getSession().getAttribute("user");
        DAO dao= DAO.getInst();
        List<Subscr> subscrs=dao.subDao.getAll("WHERE FK_Subscriber="+user.getID());
        List<Periodical> subscription=new ArrayList<Periodical>(){
            @Override
            public String toString() {
                StringBuilder sb=new StringBuilder("<p>Hello, "+user.getName()+"!</p>");
                if (!this.isEmpty()){
                    sb.append(Messages.SUBSCRIBES);
                    for (Periodical peri:this) {
                        sb.append("<p>").append(peri).append("</p>");
                    }
                } else {sb.append(Messages.NO_SUBSCRIBES);}
                return sb.toString();
            }
        };
        for (Subscr sub: subscrs) {
            subscription.add(sub.getPeriodical());
        }
        req.setAttribute("subscription", subscription);
        if (user.getRole().getParticipant().equalsIgnoreCase("Administrator")) {
            String addlink= Messages.ADD_MEDIA_LINK;
            req.setAttribute("addlink", addlink);
        }
        if (profile.isPost()) {
                String value = req.getParameter("logout");
                if (value.equals("1")) {
                    req.getSession().invalidate();
                }
                return Actions.LOGIN.action;
        }
        return null;
    }
}
