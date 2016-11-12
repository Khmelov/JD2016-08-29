package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.beans.Rent;
import by.it.savelyeva.project.java.beans.User;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by nato on 11/2/16.
 */

public class CmdCreateRent extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
            return Actions.LOGIN.action;
        }

        if (Form.isPost(req)) {
            Rent rent = new Rent();
            try {
                rent.setIdCar(Form.getInt(req, "idCar"));
                rent.setIdUser(user.getId());
                rent.setStartDate(Form.getString(req, "startDate", IPattern.DATE));
                rent.setEndDate(Form.getString(req, "endDate", IPattern.DATE));
                rent.setCost(Integer.valueOf(Form.getString(req, "cost", IPattern.ID)));
                rent.setPaid(false);
                DAO dao = DAO.getDAO();
                if (dao.rent.create(rent)){
                    return Actions.SUCCESS.action;
                }
                else
                {
                    Form.showError(req, "Database error");
                }
            } catch (ParseException e) {
                Form.showError(req, "Invalid data");
            } catch (Exception e) {
                Form.showError(req, "Incorrect data");
            }
        }
        return null;
    }
}
