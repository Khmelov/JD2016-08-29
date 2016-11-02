package by.it.tsydzik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public enum Actions {
    SIGNUP {{
        this.action = new CmdSignUp();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    LOGOUT {{
        this.action = new CmdLogout();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    //TODO
    //Factory -> вынести в отдельный класс и назвать FactoryAction!!!!!!!
    static Action defineFrom(HttpServletRequest req) {
        String command = req.getParameter("command");
        Action res;
        try {
            res = Actions.valueOf(command.toUpperCase()).action;
        } catch (Exception e) {
            res = Actions.ERROR.action;
        }
        return res;
    }

}
