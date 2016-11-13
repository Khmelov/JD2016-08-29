package by.it.tsiamruk.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by waldemar on 02/11/2016.
 */
public class Form {
    static String getParameter(HttpServletRequest req, String name, String pattern) throws ParseException{
        String value = req.getParameter(name);
        if ((value!=null) && (value.matches(pattern)))
            return value;
        else
            throw new ParseException("Incorrect String "+ name,0);
    }
    static Double getDouble(HttpServletRequest req, String name, String pattern) throws ParseException{
        String data = req.getParameter(name);
        Double value = Double.parseDouble(data.trim());
        if (value!= 0)
            return value;
        else
            throw new ParseException("Incorrect number"+name,0);
    }
    static int getInteger(HttpServletRequest req, String name, String pattern) throws ParseException{
        String data = req.getParameter(name);
        int res = Integer.parseInt(data.trim());
        if ((res != 0) && (data.matches(pattern)))
            return res;
        else throw new ParseException("Incorrect number"+name,0);
    }
    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }

    static void showMessage(HttpServletRequest req,String message){
        req.setAttribute(Messages.MESSAGE, message);
    }
    static void showError(HttpServletRequest req,String error){
        req.setAttribute(Messages.MESSAGE_ERROR, error);
    }
}
