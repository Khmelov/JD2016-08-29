package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Account;
import by.it.tsiamruk.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdShowUserAccounts extends Action {

    @Override
    Action execute(HttpServletRequest req) {
//        не понятно по чему проверка с помощью сессии не работает
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            Form.showMessage(req, "Пожалуйста войдите в систему");
            return Actions.LOGIN.action;
        }
        SingletonDAO dao = SingletonDAO.getDAO();
        List<Account> accounts = dao.account.getAll("");
        Iterator<Account> useraccIterator = accounts.iterator();
        while (useraccIterator.hasNext()){
            if (useraccIterator.next().getUsers_ID() != user.getId())
                useraccIterator.remove();
        }
            req.setAttribute("accounts", accounts);
        Account account = new Account();
                if (Form.isPost(req)) {
                try {
                    String buttonName = "singlebutton";
                    int buttonValue = Integer.parseInt(Form.getParameter(req,buttonName,"."));


                    //находим необходимый бин
                        for(Account a: accounts){
                            if (a.getStatus().equals("Unlocked") && a.getUsers_ID()== buttonValue)
                                account = a;
                        }
                        account.setStatus("Blocked");
                        dao.account.updateStatus(account);
                        return Actions.SHOWACCOUNTS.action;

                } catch (Exception e) {
                    e.getMessage();
                }
            }

        return null;
    }
}
