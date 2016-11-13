package by.it.artiuschik.project2.java.controller;

import by.it.artiuschik.project2.java.beans.Question;
import by.it.artiuschik.project2.java.beans.User;
import by.it.artiuschik.project2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowResult extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        if(Form.isPost(req))
        {
            try {
                int sum=0;
                DAO dao=DAO.getDAO();
                List<Question> questions = (List<Question>) req.getSession().getAttribute("questions");
                User user =(User) req.getSession().getAttribute("user");
                for (Question question : questions) {
                    int value = Form.getInt(req, "checkboxGroup" + question.getID());
                    if (value == 1) {
                        user.setBalls(user.getBalls() + question.getBalls());
                        dao.user.update(user);
                        sum += question.getBalls();
                    }
                }
                req.setAttribute("result","Your result="+sum);
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
}
