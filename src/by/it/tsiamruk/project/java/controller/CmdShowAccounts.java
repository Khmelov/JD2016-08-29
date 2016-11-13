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
//        не понятно по чему проверка с помощью сессии не работает
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            Form.showMessage(req, "Пожалуйста войдите в систему");
            return Actions.INDEX.action;
        }
        if (user.getFk_role() != 1)
            return Actions.SHOWUSERACCOUNTS.action;
        else {
            SingletonDAO dao = SingletonDAO.getDAO();
            List<Account> accounts = dao.account.getAll("");
            req.setAttribute("accounts", accounts);
            if (Form.isPost(req)) {
                try {
                    String buttonName = "singlebutton";
                    //получаем имя необходимое для изменения статуса счета
                    Account account = dao.account.read(Integer.parseInt(Form.getParameter(req, buttonName, Patterns.NUMBERS)));


                    //делаем действие по изменению статуса

                    account.setStatus("Unlocked");
                    dao.account.updateStatus(account);
                    return Actions.SHOWACCOUNTS.action;

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return null;
    }
}
