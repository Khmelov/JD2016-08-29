package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static String getString(HttpServletRequest req,
                            String parameter,
                            String pattern) throws ParseException {
        String value = req.getParameter(parameter);
        if (value != null) {
            if (value.matches(pattern))
                return value;
            else
                throw new ParseException("Incorrect value: " + parameter, 0);
        }
        return null;
    }

    static int getInt(HttpServletRequest req,
                      String parameter) throws ParseException {
        String value = req.getParameter(parameter);
        if (value != null) {
            if (value.matches("[0-9-]+")) {
                return (Integer.parseInt(value));
            }
        }
        throw new ParseException("Incorrect value: " + parameter, 0);
    }

    static double getDouble(HttpServletRequest req,
                            String parameter) throws ParseException {
        String value = req.getParameter(parameter);
        if (value != null) {
            if (value.matches("[.,0-9-]+")) {
                return (Double.parseDouble(value));
            }
        }
        throw new ParseException("Incorrect value: " + parameter, 0);
    }

    static boolean getBoolean(HttpServletRequest req,
                            String parameter) throws ParseException {
        String value = req.getParameter(parameter);
        if (value != null) {
            value = value.trim().toLowerCase();
            if (value.matches(IPattern.BOOL)) {
                return (Boolean.parseBoolean(value));
            }
        }
        throw new ParseException("Incorrect value: " + parameter, 0);
    }

    static boolean isPost(HttpServletRequest req) {
        return (req.getMethod() != null && req.getMethod().equalsIgnoreCase("post"));
    }

    static void showMessage(HttpServletRequest req, String message) {
        req.setAttribute(Messages.MESSAGE, message);
    }

    static void showError(HttpServletRequest req, String error) {
        req.setAttribute(Messages.MESSAGE_ERROR, error);
    }

}