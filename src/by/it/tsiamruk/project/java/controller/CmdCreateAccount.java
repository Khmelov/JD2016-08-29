package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.DAO.UserDAO;
import by.it.tsiamruk.project.java.beans.Account;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdCreateAccount extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            Account account = new Account();
            try {
                account.setAmount(Form.getValue(req,"amount"));
                account.setUsers_ID(((User) req.getSession().getAttribute("user")).getId());
                SingletonDAO dao = SingletonDAO.getDAO();
                if (dao.account.create(account))
                    return Actions.PROFILE.action;
                else {
                    Form.showError(req,"Incorrect value");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req,"Incorrect value");
                return null;
            }
        }
        return null;
    }
}
