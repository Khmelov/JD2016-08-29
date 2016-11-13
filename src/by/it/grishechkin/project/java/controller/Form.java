package by.it.grishechkin.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static String getString(HttpServletRequest req, String name, String pattern)
            throws ParseException {
            String value=req.getParameter(name);
            if ((value!=null) && value.matches(pattern)){
                return value;
            }
        else
            throw new ParseException("Incorrect String"+name,0);
    }

    static int getInt(HttpServletRequest req, String name)
            throws ParseException {
        String value=req.getParameter(name);
        if ((value!=null) && value.matches("[0-9-]*")){
            return Integer.parseInt(value);
        }
        else
            throw new ParseException("Incorrect String"+name,0);
    }

    static double getDouble(HttpServletRequest req, String name)
            throws ParseException {
        String value=req.getParameter(name);
        if ((value!=null) && value.matches("[0-9-.]*")){
            return Double.parseDouble(value);
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
