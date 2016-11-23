package by.it.artiuschik.project_Testing_system.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private RequestDispatcher disp(Action action) {
        ServletContext context = getServletContext();
        String landingJsp = action.getJsp();
        return context.getRequestDispatcher(landingJsp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action redirectAction = action.execute(req);
        if(redirectAction!=null) {
                resp.sendRedirect("do?command=" + redirectAction);
        }else {
            disp(action).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action= Actions.defineFrom(req);
        Action nexAction=action.execute(req);

        if (nexAction==null) {
            RequestDispatcher r =
                    getServletContext().
                            getRequestDispatcher(action.getJsp());
            r.forward(req,resp);
        }
        else
            resp.sendRedirect("do?command="+nexAction);
    }
}
