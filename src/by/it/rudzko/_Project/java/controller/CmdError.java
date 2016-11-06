package by.it.rudzko._Project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdError extends Action {
    private String error;

    @Override
    Action execute(HttpServletRequest req) {
        req.setAttribute(Messages.MESSAGE_ERROR, error);
        return null;
    }
}
