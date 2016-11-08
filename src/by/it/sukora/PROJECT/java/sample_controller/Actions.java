package by.it.sukora.PROJECT.java.sample_controller;


import javax.servlet.http.HttpServletRequest;

public enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    SHOWUSERS {{
        this.action = new CmdShowUsers();
    }},
    SIGNUP {{
        this.action = new CmdSignUp();
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

    static Action defineFrim(HttpServletRequest req) {
        Action res = Actions.INDEX.action;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            try {
                res = Actions.valueOf(command.toUpperCase()).action;
            } catch (Exception e) {
                res = Actions.ERROR.action;
            }
        return res;
    }


}