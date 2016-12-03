package by.it.artiuschik.project_Testing_system.java.controller;

import by.it.artiuschik.project_Testing_system.java.beans.Test;
import by.it.artiuschik.project_Testing_system.java.beans.User;
import by.it.artiuschik.project_Testing_system.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class CmdCreateTest extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (Form.isPost(req)) {
            Test test = new Test();
            try {
                test.setName(Form.getParameter(req, "Name", Patterns.TEST_NAME));
                test.setSubject(Form.getParameter(req, "Subject", Patterns.TEXT));
                test.setQuestions(Form.getInt(req, "Questions"));
                DAO dao = DAO.getDAO();
                if (dao.test.create(test)) {
                    req.getSession().setAttribute("FK_TEST", test.getID());
                    req.getSession().setAttribute("Subject", test.getSubject());
                    req.getSession().setAttribute("questionsAmount", test.getQuestions());
                    req.setAttribute("questions_amount", test.getQuestions());
                    return Actions.FILLQUESTIONS.action;
                } else {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data" + test);
                return null;
            }
        }
        return null;
    }
}
