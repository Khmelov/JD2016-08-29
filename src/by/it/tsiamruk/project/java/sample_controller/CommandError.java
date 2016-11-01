package by.it.tsiamruk.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Actions.ERROR.jsp;
    }
}