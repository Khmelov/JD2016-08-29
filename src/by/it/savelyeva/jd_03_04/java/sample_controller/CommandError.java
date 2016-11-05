package by.it.savelyeva.jd_03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Actions.ERROR.jsp;
    }
}