package by.it.senchenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


public class Form {
    static String getParameter(HttpServletRequest req, String name, String pattern)
    throws ParseException{
        String value=req.getParameter(name);
        if ((value!=null)&&value.matches(pattern)){
            return value;
        }else {
            throw new ParseException("Incorrect String"+name,0);
        }

    }
    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }
}
