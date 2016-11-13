package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Account;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        SingletonDAO dao = SingletonDAO.getDAO();
        List<Account> accounts = dao.account.getAll("");
        req.setAttribute("accounts", accounts);
        return null;
    }
}
