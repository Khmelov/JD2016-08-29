package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.DataBase;
import by.it.rudzko._Project.java.Strings.Params;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Olga Rudzko
 *         Project servlet with defaul structure
 */

public class FrontController extends HttpServlet {

    private RequestDispatcher disp(Action action) {
        ServletContext context = getServletContext();
        String landingJsp = action.getJsp();
        return context.getRequestDispatcher(landingJsp);
    }

    @Override
    public void init() throws ServletException {
        DataBase db = new DataBase();
        db.buildDefaultStructure();
        db.reset();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Form f = new Form(req, resp);
        Action action = Actions.defineFrom(f);
        Action redirectAction = action.execute(f);
        if (redirectAction != null) {
            resp.sendRedirect(Params.JSP_DO_COMMAND + redirectAction);
        } else {
            disp(action).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void destroy() {
        new DataBase().deleteTables();
    }

}
