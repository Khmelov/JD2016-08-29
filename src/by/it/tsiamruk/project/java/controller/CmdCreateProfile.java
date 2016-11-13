package by.it.tsiamruk.project.java.controller;

import by.it.tsiamruk.project.java.DAO.SingletonDAO;
import by.it.tsiamruk.project.java.beans.Profile;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import by.it.tsiamruk.project.java.beans.User;

/**
 * Created by waldemar on 02/11/2016.
 */
public class CmdCreateProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            Profile profile = new Profile();
            try {
                profile.setName(Form.getParameter(req,"Name",Patterns.NAME));
                profile.setLastname(Form.getParameter(req,"Lastname",Patterns.NAME));
                profile.setAge(Form.getInteger(req,"Age",Patterns.NUMBERS));
                profile.setId(((User) req.getSession().getAttribute("user")).getId());
                SingletonDAO dao = SingletonDAO.getDAO();
                if (dao.profile.create(profile))
                    return Actions.CREATEACCOUNT.action;
                else {
                    Form.showError(req,"Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req,"Incorrect value");
                return null;
            }
        }
        return null;
    }
}
