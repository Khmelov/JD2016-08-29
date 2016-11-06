package by.it.rudzko._Project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX {{
        this.action = new CmdIndex();
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
    }},
    CATALOGUE{{
        this.action = new CmdCatalogue();
    }},
    ADD{{
        this.action = new CmdAdd();
    }}
    ;

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
        Action res = INDEX.action;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty())
            try {
                res = valueOf(command.toUpperCase()).action;
            } catch (Exception e) {
                res = ERROR.action;
            }
        return res;
    }

}
