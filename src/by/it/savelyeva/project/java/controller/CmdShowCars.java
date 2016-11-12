package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.*;
import by.it.savelyeva.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowCars extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<Car> cars = dao.car.getAll("");
        req.setAttribute("cars", cars);

        List<Manufacturer> manufacturers = dao.manufacturer.getAll("");
        req.setAttribute("manufacturers", manufacturers);

        List<Model> models = dao.model.getAll("");
        req.setAttribute("models", models);

        List<Color> colors = dao.color.getAll("");
        req.setAttribute("colors", colors);

        List<Transmission> transmissions = dao.transmission.getAll("");
        req.setAttribute("transmissions", transmissions);

        return null;
    }
}
