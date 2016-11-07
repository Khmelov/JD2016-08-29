package by.it.tsiamruk.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            try {
                String value = Form.getParameter(req,"LogoutButton","1");
                if (value.equals("1")){
                    req.getSession().invalidate();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
