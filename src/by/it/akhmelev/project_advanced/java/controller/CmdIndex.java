package by.it.akhmelev.project_advanced.java.controller;

import by.it.akhmelev.project_advanced.java.beans.Ad;
import by.it.akhmelev.project_advanced.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        AtomicInteger startNumber = new AtomicInteger(0);
        try {
            startNumber.set(Form.getInt(req, "startNumber"));
        } catch (ParseException e) {
            startNumber.set(0);
        }
        String limit = String.format(" LIMIT %s,%s", startNumber.get(), 8);
        List<Ad> ads = dao.ad.getAll(limit);
        req.setAttribute("adCount", dao.ad.getCount(""));
        for (Ad ad : ads) {
            ad.setViewNumber(startNumber.incrementAndGet());
        }
        req.setAttribute("ads", ads);
        return null;
    }
}
