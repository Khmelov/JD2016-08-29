package by.it.sukora.PROJECT.java.sample_controller;

import by.it.sukora.PROJECT.java.beans.Role;
import by.it.sukora.PROJECT.java.beans.Users;
import by.it.sukora.PROJECT.java.beans.diagnosis;
import by.it.sukora.PROJECT.java.custom_dao.DAO;
import by.it.sukora.PROJECT.java.custom_dao.DiagnosisDAO;
import by.it.sukora.PROJECT.java.custom_dao.MedicalcardDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        DAO dao = DAO.getDAO();
        List<diagnosis> userses = dao.diagnosis.getAll("");
       // List<Role> roles = dao.Role.getAll("");
        req.setAttribute("diagnosis", userses);
       // req.setAttribute("roles", roles);
        return null;
    }
}
