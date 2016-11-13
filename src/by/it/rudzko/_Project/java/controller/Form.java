package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.Strings.Messages;
import by.it.rudzko._Project.java.Strings.Variables;
import by.it.rudzko._Project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Olga Rudzko
 *         saves servlet response and servlet request
 */
public class Form {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public Form(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public HttpServletRequest getReq() {
        return req;
    }

    /**
     * gets input parameter
     *
     * @param name    name of input parameter
     * @param pattern parameter name should match to this pattern
     * @return input parameter
     * @throws ParseException incorrect data
     */
    String getParameter(String name, String pattern)
            throws ParseException {
        String value = req.getParameter(name);
        if ((value != null) && value.matches(pattern)) {
            return value;
        } else
            throw new ParseException(name + Messages.INCORRECT_DATA, 0);
    }

    String getParameter(String name) {
        return req.getParameter(name);
    }

    boolean isPost() {
        return req.getMethod().equalsIgnoreCase("post");
    }

    /**
     * sets attribute to request context
     *
     * @param name name of attribute
     * @param obj  value of attribute
     */
    void setReqAttr(String name, Object obj) {
        this.getReq().setAttribute(name, obj);
    }

    /**
     * sends error message
     *
     * @param error error message
     */
    void setError(String error) {
        setReqAttr(Messages.MESSAGE_ERROR, error);
    }

    /**
     * sets attribute for session context
     *
     * @param name name of parameter
     * @param obj value of perameter
     */
    void setSessionAttr(String name, Object obj) {
        this.getReq().getSession().setAttribute(name, obj);
    }

    /**
     * gets value of attribute from session context
     *
     * @param name name of attribute
     * @return object of session attribute
     */
    Object getSessionAttr(String name) {
        return this.getReq().getSession().getAttribute(name);
    }

    /**
     * adds Cookie
     *
     * @param login    login of user who started session
     * @param password password of user who started session
     */
    void setCookie(String login, String password) {
        Cookie myCookie = new Cookie(login, String.valueOf(password.hashCode()));
        myCookie.setMaxAge(30);
        resp.addCookie(myCookie);
    }

    /**
     * identifies current year
     *
     * @return current year
     */
    int getCurYear() {
        Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        c.setTime(new Date());
        return c.get(java.util.Calendar.YEAR);
    }

    /**
     * identifies role of user
     * @param user current user
     * @return true if user is administrator
     */
    boolean admin(User user) {
        return user.getRole().getParticipant().equalsIgnoreCase(Variables.ADMINISTRATOR);
    }
}
