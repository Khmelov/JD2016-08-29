package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by nato on 11/2/16.
 */
public class CmdLogout extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.action;
        }
        return null;
    }
}