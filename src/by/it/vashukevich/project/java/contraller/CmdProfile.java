package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Courses;
import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdProfile extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            try {
                String value=Form.getString(req,"LogoutButton","1");
                if (value.equals("1")){
                    req.getSession().invalidate();
                    return Actions.LOGIN.action;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Users user=(Users) req.getSession().getAttribute("user");
        if (user!=null){
            List<Courses> courses= DAO.getDAO().courses.getAll(String.format(" where User='%d'",user.getId()));
            req.setAttribute("courses",courses);
        }

        return null;
    }
}
