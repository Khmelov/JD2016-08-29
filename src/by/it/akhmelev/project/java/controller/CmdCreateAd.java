package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdCreateAd extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        User user=(User)req.getSession().getAttribute("user");
        if (user==null)
            return Actions.LOGIN.action;
        if (Form.isPost(req)){
            Ad ad=new Ad();
            try {
                ad.setAddress(Form.getString(req,"Address",".*"));
                ad.setArea(Form.getDouble(req,"Area"));
                ad.setDescription(Form.getString(req,"Description",".*"));
                ad.setFK_Users(user.getId());
                ad.setFloor(Form.getInt(req,"Floor"));
                ad.setFloors(Form.getInt(req,"Floors"));
                ad.setPrice(Form.getDouble(req,"Price"));
                ad.setRoomCount(Form.getInt(req,"RoomCount"));
                DAO.getDAO().ad.create(ad);
                return Actions.INDEX.action;
            } catch (ParseException e) {
                return Actions.ERROR.action;
            }
        }
        return null;
    }
}
