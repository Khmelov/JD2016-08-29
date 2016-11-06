package by.it.grishechkin.project.java.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yury on 04.11.2016.
 */
public class HelloYury extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter prn = resp.getWriter();
        prn.println("<br><br>Hello world!!");
        prn.println("<br>URI:" + req.getRequestURI());
        prn.flush();
    }
}
