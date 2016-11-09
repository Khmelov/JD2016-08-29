package by.it.akhmelev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    CREATEAD {{
        this.action = new CmdCreateAd();
    }},
    SHOWUSERS {{
        this.action = new CmdShowUsers();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    ERROR {{
        this.action = new CmdError();
    }},;

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
        Action res = Actions.INDEX.action;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            try {
                res = Actions.valueOf(command.toUpperCase()).action;
            } catch (Exception e) {
                //
                res = Actions.ERROR.action;
            }
        return res;
    }

}
