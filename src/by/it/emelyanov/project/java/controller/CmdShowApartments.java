package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Rooms;
import by.it.emelyanov.project.java.beans.Types;
import by.it.emelyanov.project.java.beans.Users;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class CmdShowApartments extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        Users user = (Users) req.getSession().getAttribute("user");
        if (user == null)
            return Actions.LOGIN.action;
        if (user.getfK_Role() != 1) {
            Form.showMessage(req, "Недостаточно прав");
            Form.showError(req, "Ошибка");
        } else {
            if (Form.isPost(req)) {
                Rooms roomFromForm = new Rooms();
                try {
                    roomFromForm.setId(Form.getInt(req, "ID", Patterns.NUMB));
                    roomFromForm.setFloor(Form.getInt(req, "Floor", Patterns.NUMB));
                    roomFromForm.setRoom_Number(Form.getInt(req, "Room_Number", Patterns.NUMB));
                    roomFromForm.setCost(Form.getFloat(req, "Cost", Patterns.MONEY));
                    roomFromForm.setfK_Type(Form.getInt(req, "fk_Type", Patterns.NUMB));

                    if (roomFromForm.getId() > 0) {
                        dao.roomsDAO.update(roomFromForm);
                    } else if (roomFromForm.getId() == 0) {
                        dao.roomsDAO.create(roomFromForm);
                    } else {
                        roomFromForm.setId(-1 * roomFromForm.getId());
                        dao.roomsDAO.delete(roomFromForm);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            List<Rooms> rooms = dao.roomsDAO.getAll("");
            req.setAttribute("rooms", rooms);
            List<Types> types = dao.typesDAO.getAll("");
            req.setAttribute("types", types);
        }
        return null;
    }
}
