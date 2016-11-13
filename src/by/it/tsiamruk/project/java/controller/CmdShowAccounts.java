package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Account;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdShowAccounts extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        SingletonDAO dao = SingletonDAO.getDAO();
        List<Account> accounts = dao.account.getAll("");
        req.setAttribute("accounts", accounts);
        User user = (User) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getFk_role() != 1) {
            return Actions.INDEX.action;
        } else{
            if (Form.isPost(req)) {
                try {
                    //получаем имя необходимое для изменения статуса счета
                    Account account = new Account();
                    for(Account a: accounts){
                        if (a.getStatus().equals("Blocked"))
                            account = a;
                    }
                    String buttonName = "singlebutton";
                    //делаем действие по изменению статуса
                    if (Form.getParameter(req, buttonName, account.getUsers_ID().toString()).equals(account.getUsers_ID().toString())) {
                        account.setStatus("Unlocked");
                        dao.account.updateStatus(account);
                        return Actions.SHOWACCOUNTS.action;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return null;
    }
}
