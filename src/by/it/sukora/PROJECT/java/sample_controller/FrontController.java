package by.it.sukora.PROJECT.java.sample_controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private RequestDispatcher dispatcher(Action action) {
        ServletContext context = getServletContext();
        String landingJsp = action.getJsp();
        return context.getRequestDispatcher(landingJsp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrim(req);
        Action rediirectAction = action.execute(req);
        if (rediirectAction != null) {
            resp.sendRedirect("do?command=" + rediirectAction);
        } else {
            dispatcher(action).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrim(req);
        action.execute(req);
        dispatcher(action).forward(req, resp);
    }

}