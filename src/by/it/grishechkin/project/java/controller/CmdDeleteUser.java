package by.it.grishechkin.project.java.controller;

import by.it.grishechkin.project.java.DAO.DAO;
import by.it.grishechkin.project.java.beans.Order;
import by.it.grishechkin.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Yury on 13.11.2016.
 */
public class CmdDeleteUser extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = new User();
        if (Form.isPost(req)) {
            try {
                user.setID(Form.getInt(req, "userID"));
                DAO.getDAO().user.delete(user);
                return Actions.ADMIN.action;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
