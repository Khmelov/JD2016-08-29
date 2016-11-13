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
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            Form.showMessage(req, "Пожалуйста войдите в систему");
            return Actions.LOGIN.action;
        }
        //инициализация дао и создания списка счетов и отдельного класса счет для управления конкретным счетом
        SingletonDAO dao = SingletonDAO.getDAO();
        List<Account> accounts = dao.account.getAll("");
        Account account;
        //Отсеиваю лишние элементы списка(можно сделать просто метод в ДАО с SQL запросом
        Iterator<Account> useraccIterator = accounts.iterator();
        while (useraccIterator.hasNext()) {
            if (useraccIterator.next().getUsers_ID() != user.getId())
                useraccIterator.remove();
        }
        req.setAttribute("accounts", accounts);

        if (Form.isPost(req)) {
            try {
                //находим необходимую запись
                account = dao.account.read(Integer.parseInt(Form.getParameter(req, "singlebutton", Patterns.NUMBERS)));
                //меняем статус
                account.setStatus("Blocked");
                dao.account.updateStatus(account);
                return Actions.SHOWUSERACCOUNTS.action;

            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }

}
