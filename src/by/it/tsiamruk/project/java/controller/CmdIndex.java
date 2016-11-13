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
        if (Form.isPost(req)){
            try {
                String loginbutton = Form.getParameter(req,"Log","1");
                String signupbutton = Form.getParameter(req,"singnupbutton","1");
                if (loginbutton.equals("1"))
                    return Actions.LOGIN.action;
                if (signupbutton.equals("1"))
                    return Actions.SIGNUP.action;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
