package by.it.vashukevich.project.java.contraller;

import by.it.vashukevich.project.java.beans.Courses;
import by.it.vashukevich.project.java.beans.Users;
import by.it.vashukevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowCourses extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        if (Form.isPost(req)) {
            Courses coursesFromForm = new Courses();
            try {
                coursesFromForm.setId(Form.getInt(req,"Id"));
                coursesFromForm.setName(Form.getString(req,"Name",Patterns.NAME));
                coursesFromForm.setUser(Form.getInt(req,"User"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<Courses> courses = dao.courses.getAll("");
        req.setAttribute("courses", courses);
        //List<Users> users=dao.users.getAll("");
        //req.setAttribute("users",users);

        return null;
    }

    public static void main(String[] args) {
        System.out.println(DAO.getDAO().courses.getAll(""));
    }
}



