package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.Rent;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CmdIndex extends Action {
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
        List<Rent> rents = dao.rent.getAll(limit);
        req.setAttribute("rentCount", dao.rent.getCount(""));
        for (Rent rent : rents) {
            rent.setViewNumber(startNumber.incrementAndGet());
        }
        req.setAttribute("rents", rents);
        return null;
    }
}