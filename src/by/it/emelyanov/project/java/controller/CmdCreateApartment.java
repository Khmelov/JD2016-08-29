package by.it.emelyanov.project.java.controller;

import by.it.emelyanov.project.java.beans.Rooms;
import by.it.emelyanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdCreateApartment extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            Rooms room = new Rooms();
            try {
                room.setId(0);
                room.setFloor(Integer.parseInt(Form.getParameter(req,"Floor",Patterns.NUMB)));
                room.setRoom_Number(Integer.parseInt(Form.getParameter(req,"Room_Number",Patterns.NUMB)));
                room.setCost(Float.parseFloat(Form.getParameter(req,"Cost",Patterns.MONEY)));
                room.setfK_Type(4);

                DAO dao=DAO.getDAO();
                if (dao.roomsDAO.create(room)){
                    return Actions.INDEX.action;
                }
                else
                {
                    Form.showError(req,"Database error");
                    return null;
                }
            } catch (ParseException e) {
                Form.showError(req,"Incorrect data");
                return null;
            }
        }
        return null;
    }
}
