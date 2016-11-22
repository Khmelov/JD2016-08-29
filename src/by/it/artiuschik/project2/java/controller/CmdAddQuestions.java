package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

class CmdAddQuestions extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            DAO dao = DAO.getDAO();
            int questionsAmount=(Integer)req.getSession().getAttribute("questionsAmount");

            try {
                int testID=(Integer) req.getSession().getAttribute("FK_TEST");
                String subject=(String)req.getSession().getAttribute("Subject");
                for (int i = 0; i <questionsAmount; i++) {
                    Question question=new Question();
                    question.setID(i);
                    question.setFK_TEST(testID);
                    question.setSubject(subject);
                    question.setText(Form.getParameter(req, "QuestionText" + i, Patterns.QUESTION_TEXT));
                    question.setBalls(Form.getInt(req, "Balls" + i));
                    question.setAnswer(Form.getInt(req, "Answer" + i));
                    question.setVarianta(Form.getParameter(req, "Varianta" + i,Patterns.QUESTION_TEXT));
                    question.setVariantb(Form.getParameter(req, "Variantb" + i,Patterns.QUESTION_TEXT));
                    dao.question.create(question);
                }
                return Actions.PROFILE.action;
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data"+e.getMessage());
                return null;
            }
        }
            return null;

    }
}
