package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Courses;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao=DAO.getDAO();
        List<Courses>courses=dao.courses.getAll("");
        req.setAttribute("courses",courses);
        return null;
    }
}
