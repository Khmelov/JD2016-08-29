package by.it.rudzko._Project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdError extends Action {

    @Override
    Action execute(HttpServletRequest req) {
        req.setAttribute(Messages.MESSAGE_ERROR, Messages.NO_PAGE);
        return null;
    }
}
