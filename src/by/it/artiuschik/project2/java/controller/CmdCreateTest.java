package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.beans.Test;
import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CmdCreateTest  extends Action
{
    @Override
    Action execute(HttpServletRequest req) {
        User user=(User)req.getSession().getAttribute("user");
        if (user==null)
            return Actions.LOGIN.action;
        if (Form.isPost(req)) {
            Test test = new Test();
            try {
                test.setName(Form.getString(req, "Name", Patterns.TEXT));
                test.setSubject(Form.getString(req, "Subject", Patterns.TEXT));
                test.setQuestions(Form.getInt(req,"Questions"));
                DAO dao= DAO.getDAO();
                if(dao.test.create(test)) {
                    List<Question> questions=new ArrayList<>();
                    for (int i = 0; i < test.getQuestions(); i++) {
                        questions.add(new Question(i,"",test.getSubject(),"","",0,test.getID()));
                    }
                    //req.setAttribute() не работает
                    req.getSession().setAttribute("questions",questions);
                    return Actions.FILLQUESTIONS.action;
                }
                else {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data"+test);
                return null;
            }
        }
        return null;
    }
}
