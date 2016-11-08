package by.it.savelyeva.jd_03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new CommandError();

        String action = request.getParameter("command");

        if (action != null && !action.isEmpty()) {
            try {
                Actions currentEnum = Actions.valueOf(action.toUpperCase());
                current = currentEnum.getCurrentCommand();
                request.setAttribute(Messages.msgError, "<b>OK: '" + action + "' action was found</b>");
                request.setAttribute(Messages.msgMessage, "<b>OK: '" + action + "' action was found</b>");

            } catch (IllegalArgumentException e) {
                request.setAttribute(Messages.msgError, "<b>Unknown command: '" + action + "' action was NOT found</b>");
                request.setAttribute(Messages.msgMessage, "<b>Unknown command: '" + action + "' action was NOT found</b>");
            }
        }
        return current;
    }
}