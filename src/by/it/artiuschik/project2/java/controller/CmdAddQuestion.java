package by.it.artiuschik.project2.java.controller;
import by.it.artiuschik.project2.java.beans.Test;
import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdAddQuestion extends Action
{
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Question qOne=new Question();
            DAO dao=DAO.getDAO();
            try {
                //Создание вопроса 1
                String testName= Form.getParameter(req, "TestName", Patterns.TEXT);
                Test test=dao.test.getTest(testName);
                if(test!=null) {
                    qOne.setText(Form.getParameter(req, "QuestionText",Patterns.TEXT));
                    qOne.setBalls(Integer.parseInt(Form.getParameter(req, "Balls", Patterns.LOGIN)));
                    qOne.setSubject(test.getSubject());
                    qOne.setFK_TEST(test.getID());
                    int qNumber = test.getQuestions();
                    test.setQuestions(qNumber++);
                    dao.test.update(test);
                    if (dao.question.create(qOne)) {
                        return Actions.PROFILE.action;
                    } else {
                        Form.showError(req, "Database error");
                        return null;
                    }
                }
                else {
                    Form.showError(req, "Test with this name is not exist!");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
        return null;
    }
}
