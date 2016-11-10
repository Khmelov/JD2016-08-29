package by.it.akhmelev.project_advanced.java.controller;

import by.it.akhmelev.project_advanced.java.beans.Ad;
import by.it.akhmelev.project_advanced.java.beans.User;
import by.it.akhmelev.project_advanced.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.action;
        }
        else
        {
            User user=(User)req.getSession().getAttribute("user");
            DAO dao=DAO.getDAO();
            int startNumber;
            try {
                startNumber= Form.getInt(req,"startNumber");
            } catch (ParseException e) {
                startNumber=0;
            }
            String limit=String.format("where FK_Users=%d LIMIT %s,%s",user.getId(),startNumber,5);
            List<Ad> ads = dao.ad.getAll(limit);
            int adCount=dao.ad.getCount(String.format("where FK_Users=%d",user.getId()));
            req.setAttribute("adCount", adCount);
            for (Ad ad : ads) {
                ad.setViewNumber(++startNumber);
            }
            req.setAttribute("ads", ads);


        }
        return null;
    }
}
