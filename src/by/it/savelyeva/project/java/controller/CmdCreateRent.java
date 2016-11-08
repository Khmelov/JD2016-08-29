package by.it.savelyeva.project.java.controller;

import by.it.savelyeva.project.java.beans.Rent;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by nato on 11/2/16.
 */

public class CmdCreateRent extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Rent rent = new Rent();
            try {
                rent.setIdCar(Integer.valueOf(Form.getParameter(req, "idCar", IPattern.ID)));
                rent.setIdUser(1); //(Integer.valueOf(Form.getParameter(req, "idUser", IPattern.ID)));
                rent.setStartDate(Form.getParameter(req, "startDate", IPattern.DATE));
                rent.setEndDate(Form.getParameter(req, "endDate", IPattern.DATE));
                rent.setCost(Integer.valueOf(Form.getParameter(req, "cost", IPattern.ID)));
                rent.setPaid(false);//Boolean.valueOf(Form.getParameter(req, "paid", IPattern.BOOL)));
                DAO dao = DAO.getDAO();
                if (dao.rent.create(rent)){
                    return Actions.SUCCESS.action;
                }
                else
                {
                    Form.showError(req, "Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req, "Incorrect data");
                return null;
            } catch (Exception e) {
                Form.showError(req, "Incorrect data");
                return null;
            }

        }
        return null;
    }
}
