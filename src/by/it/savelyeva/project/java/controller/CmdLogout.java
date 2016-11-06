package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by nato on 11/2/16.
 */
public class CmdLogout extends Action  {
    @Override
    Action execute(HttpServletRequest req) {

        try {
            String value = Form.getParameter(req, "LogoutButton", "1");
            if (value.equals("1")) {
                req.getSession().invalidate();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
