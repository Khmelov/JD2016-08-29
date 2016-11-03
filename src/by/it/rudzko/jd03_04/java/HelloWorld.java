package by.it.rudzko.jd03_04.java;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter prn=resp.getWriter();
        resp.setHeader("Cache-control", "no-store");
        prn.println("<html><h1><p>Hello world!</p><p>URI:");
        prn.println(req.getRequestURI()+"</p></h1></html>");
        prn.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
