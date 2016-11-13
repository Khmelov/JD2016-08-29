package by.it.tsiamruk.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by wtsiamruk on 11/11/16.
 */
public class CmdLogout extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            try {
                String value=Form.getParameter(req,"LogoutButton","1");
                if (value.equals("1")){
                    req.getSession().invalidate();
                    return Actions.LOGIN.action;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
