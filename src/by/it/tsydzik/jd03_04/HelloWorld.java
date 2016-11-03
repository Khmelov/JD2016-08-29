package by.it.tsydzik.jd03_04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Eugene Tsydzik
 * @since 31.10.2016.
 */
public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(
                "<html>" +
                        "<body>" +
                        "<h1>Hello Eugene</h1>" +
                        "</body>" +
                        "</html>");
        out.flush();
    }
}
