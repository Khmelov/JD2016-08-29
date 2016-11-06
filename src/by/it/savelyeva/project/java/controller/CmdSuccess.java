package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nato on 11/2/16.
 */
public class CmdSuccess extends Action  {
    @Override
    Action execute(HttpServletRequest req) {
        req.setAttribute("message", "Изменения сохранены");
        return null;
    }
}
