package by.it.akhmelev.project.java.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        action.execute(req);

        ServletContext context=getServletContext();
        String landingJsp=action.getJsp();
        RequestDispatcher disp=context.getRequestDispatcher(landingJsp);
        disp.forward(req,resp);
    }
}
