package by.it.artiuschik.project.java.controller;

import by.it.artiuschik.project.java.beans.Question;
import by.it.artiuschik.project.java.beans.Test;
import by.it.artiuschik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdCreateTest  extends Action
{
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Test test = new Test();
            Question qOne=new Question();
            Question qTwo=new Question();
            Question qThree=new Question();
            try {
                //По умолчанию создается тест с 1 вопросом
                test.setName(Form.getParameter(req, "Name", Patterns.LOGIN));
                test.setSubject(Form.getParameter(req, "Subject", Patterns.PASSWORD));
                test.setQuestions(1);
                //Создание вопроса 1
                qOne.setText(Form.getParameter(req, "Q1", Patterns.LOGIN));
                qOne.setSubject(test.getSubject());
                qOne.setBalls(Integer.parseInt(Form.getParameter(req, "Q1Balls", Patterns.LOGIN)));
                DAO dao=DAO.getDAO();
                if(dao.test.create(test)&&dao.question.create(qOne)) {
                    return Actions.LOGIN.action;
                }
                else {
                    Form.showError(req, "Database error");
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
