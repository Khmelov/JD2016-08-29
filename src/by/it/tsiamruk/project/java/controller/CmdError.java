package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdError extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        Form.showMessage(req,"Something wrong man)");
        return null;
    }
}
