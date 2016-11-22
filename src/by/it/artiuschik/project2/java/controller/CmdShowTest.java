package by.it.artiuschik.project2.java.controller;
import by.it.artiuschik.project2.java.beans.Test;
import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class CmdShowTest extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            return Actions.LOGIN.action;
        }
        else {
            if (Form.isPost(req)) {
                DAO dao = DAO.getDAO();
                try {
                    Test test = dao.test.read(Form.getInt(req, "id"));
                    req.setAttribute("test", test);
                    req.getSession().setAttribute("chosenTest",test.getID());
                    req.setAttribute("questions", dao.question.getTestQuestions(test.getID()));
                    req.getSession().setAttribute("questionsAmount", test.getQuestions());
                    req.getSession().setAttribute("questions", dao.question.getTestQuestions(test.getID()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}
