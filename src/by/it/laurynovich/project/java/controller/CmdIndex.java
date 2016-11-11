package by.it.laurynovich.project.java.controller;

import by.it.laurynovich.project.java.beans.Ad;
import by.it.laurynovich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Ad> ads=dao.ad.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
