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
    static Double getValue(HttpServletRequest req, String name) throws ParseException{
        Double value = Double.parseDouble(req.getParameter(name.trim()));
        if (value!= 0)
            return value;
        else
            throw new ParseException("Incorrect value"+name,0);
    }
    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }
}
