package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class CmdShowResult extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            try {
                int sum = 0;
                DAO dao = DAO.getDAO();
                List<String> userAnswers = new ArrayList<>();
                int chosenTestID=(Integer) req.getSession().getAttribute("chosenTest");
                List<Question> questions = dao.question.getTestQuestions(chosenTestID);
                User user = (User) req.getSession().getAttribute("user");
                for (Question question : questions) {
                    int value = Form.getInt(req, "checkboxGroup" + question.getID());
                    if (value == 1) {
                        userAnswers.add(question.getVarianta());
                    } else {
                        if (value == 2) {
                            userAnswers.add(question.getVariantb());
                        }

                    }
                    if (value == question.getAnswer()) {
                        user.setBalls(user.getBalls() + question.getBalls());
                        dao.user.update(user);
                        sum += question.getBalls();
                    }
                }
                req.setAttribute("user_answers", userAnswers);
                req.setAttribute("questions",questions);
                req.setAttribute("result",sum);
                req.setAttribute("test_name",dao.test.getTest(chosenTestID).getName());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
