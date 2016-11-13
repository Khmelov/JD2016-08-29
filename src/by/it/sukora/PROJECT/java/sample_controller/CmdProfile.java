package by.it.sukora.PROJECT.java.sample_controller;

import by.it.sukora.PROJECT.java.beans.Users;
import by.it.sukora.PROJECT.java.beans.logpas;
import by.it.sukora.PROJECT.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {

        if (Form.isPost(req)) {
            logpas logpas = new logpas();
            try {



            } catch (Exception e) {
                Form.showMessage(req, "Неверные данные");
                Form.showError(req, "Ошибка");
                return null;
            }
            DAO dao = DAO.getDAO();
          //  List<logpas> logpas = dao.logpas.getAll()

        }
        return null;
    }
}
