package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by nato on 11/2/16.
 */

public class Form {
    static String getParameter(HttpServletRequest req, String name, String pattern)
            throws ParseException {
        String value=req.getParameter(name);
        if ((value!=null) && value.matches(pattern)){
            return value;
        }
        else
            throw new ParseException("Incorrect String"+name,0);
    }

    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }

    static void showMessage(HttpServletRequest req, String message){
        req.setAttribute(Messages.MESSAGE,message);
    }
    static void showError(HttpServletRequest req, String error){
        req.setAttribute(Messages.MESSAGE_ERROR,error);
    }
}
