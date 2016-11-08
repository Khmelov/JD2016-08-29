package by.it.artiuschik.project.java.controller;

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
        // req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        Action action = Actions.defineFrom(req);
        Action redirectAction = action.execute(req);
        if (redirectAction != null) {
            if(action instanceof CmdLogin)
            {
                Cookie login=new Cookie("Login",session.getAttribute("Login").toString());
                Cookie password=new Cookie("Pasword",session.getAttribute("Password").toString());
                resp.addCookie(login);
                resp.addCookie(password);
            }
            resp.sendRedirect("do?command=" + redirectAction);
        } else {
            disp(action).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ((session.getAttribute("Login") == null) && (session.getAttribute("Password") == null)
                && (req.getParameter("command") != null) && (!req.getParameter("command").equals("SignUp"))) {
            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            Action action = Actions.defineFrom(req);
            action.execute(req);
            disp(action).forward(req, resp);
        }
    }
}
