package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.*;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowRents extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
            return Actions.LOGIN.action;
        }
        else
        {
            DAO dao = DAO.getDAO();
            if (Form.isPost(req)) {
                Rent rentFromForm = new Rent();
                try {
                    rentFromForm.setId(Form.getInt(req, "id"));
                    rentFromForm.setIdCar(Form.getInt(req, "idCar"));
                    rentFromForm.setIdUser(Form.getInt(req, "idUser"));
                    rentFromForm.setStartDate(Form.getString(req, "startDate", IPattern.DATE));
                    rentFromForm.setEndDate(Form.getString(req, "endDate", IPattern.DATE));
                    rentFromForm.setCost(Form.getInt(req, "cost"));
                    rentFromForm.setPaid(Form.getBoolean(req, "paid"));

                    if (rentFromForm.getId() > 0) {
                        dao.rent.update(rentFromForm);
                    } else if (rentFromForm.getId() == 0) {
                        dao.rent.create(rentFromForm);
                    } else {
                        rentFromForm.setId(-1 * rentFromForm.getId());
                        dao.rent.delete(rentFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            List<User> users = dao.user.getAll("");
            req.setAttribute("users", users);

            String where = user.getIdRole() > 1 ? " WHERE idUser="+user.getId() : "";
            List<Rent> rents = dao.rent.getAll(where);
            req.setAttribute("rents", rents);
            req.setAttribute("rentsCount", rents.size());
            if (rents.size() == 0) {
                Form.showMessage(req, "Объявлений не найдено");
            }
            List<Car> cars = dao.car.getAll("");
            req.setAttribute("cars", cars);
            }
        return null;
    }
}
