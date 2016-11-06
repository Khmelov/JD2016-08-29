package by.it.savelyeva.project.java.controller;

/**
 * Created by nato on 11/5/16.
 */
import by.it.savelyeva.project.java.beans.*;
import by.it.savelyeva.project.java.dao.DAO;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ajaxservlet/*")
public class AjaxServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        DAO dao = DAO.getDAO();
        String parameter = request.getParameter("dao");
        String field = request.getParameter("field");
        String where = request.getParameter("id");
        if (where != null) {
            where = " WHERE " + field + "=" + where;
        }
        else where = "";
        String text = "";
        switch (parameter) {
            case "manufacturer": List<Manufacturer> manufacturers = dao.manufacturer.getAll(where);
                text = manufacturers.toString();
                break;
            case "model": List<Model> models = dao.model.getAll(where);
                text = models.toString();
                break;
            case "transmission": List<Transmission> transmissions = dao.transmission.getAll(where);
                text = transmissions.toString();
                break;
            case "color": List<Color> colors = dao.color.getAll(where);
                text = colors.toString();
                break;
            case "car":
                String idModel = request.getParameter("idModel");
                String idTransmission = request.getParameter("idTransmission");
                String idColor = request.getParameter("idColor");
                where = String.format(" WHERE idModel=%s AND idTransmission=%s AND idColor=%s",
                        idModel, idTransmission, idColor);
                List<Car> cars = dao.car.getAll(where);
                text = cars.toString();
                break;
        }


        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);
    }
}