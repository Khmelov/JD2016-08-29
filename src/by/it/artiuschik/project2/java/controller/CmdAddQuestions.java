package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdAddQuestions extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            DAO dao = DAO.getDAO();
            try {
                List<Question> questions = (List<Question>) req.getSession().getAttribute("questions");
                for (int i = 0; i < questions.size(); i++) {
                    questions.get(i).setText(Form.getParameter(req, "QuestionText" + i, Patterns.TEXT));
                    questions.get(i).setBalls(Form.getInt(req, "Balls" + i));
                    questions.get(i).setVarianta(Form.getParameter(req, "Varianta" + i,Patterns.TEXT));
                    questions.get(i).setVariantb(Form.getParameter(req, "Variantb" + i,Patterns.TEXT));
                    dao.question.create(questions.get(i));
                }
                return Actions.PROFILE.action;
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            }
        }
            return null;

    }
}
