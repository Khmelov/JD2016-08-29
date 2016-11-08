package by.it.rudzko._Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    private HttpServletRequest req;

    public Form(HttpServletRequest req) {
        this.req = req;
    }

    public HttpServletRequest getReq() {
        return req;
    }

    String getParameter(String name, String pattern)
            throws ParseException {
        String value = req.getParameter(name);
        if ((value != null) && value.matches(pattern)) {
            return value;
        } else
            throw new ParseException(name + Messages.INCORRECT_DATA, 0);
    }

    boolean isPost() {
        return req.getMethod().equalsIgnoreCase("post");
    }

}
