package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowUsers extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Users>userses=dao.users.getAll("");
        req.setAttribute("users",userses);
        return null;
    }
}
