package by.it.artiuschik.project.java.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if((session.getAttribute("Login")==null)&&(session.getAttribute("Password")==null))
        {
            ServletContext context=req.getServletContext();
            RequestDispatcher dispatcher=context.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req,resp);
        }
        /*else
        {
            ServletContext context=req.getServletContext();
            RequestDispatcher dispatcher=context.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req,resp);
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
