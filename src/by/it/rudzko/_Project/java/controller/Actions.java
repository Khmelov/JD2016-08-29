package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.Strings.Params;

enum Actions {
    INDEX {{
        this.action = new CmdIndex();
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
    CATALOGUE {{
        this.action = new CmdCatalogue();
    }},
    ADD {{
        this.action = new CmdAdd();
    }},
    EDITUSERS {{
        this.action = new CmdEditUsers();
    }},
    EDITREADERSHIP {{
        this.action = new CmdEditReadership();
    }},
    DELETESUB {{
        this.action = new CmdDeleteSub();
    }};

    protected Action action = null;

    /**
     * @param f contains servlet request and servlet response
     * @return new Action chose from enum
     * @see Form
     */
    static Action defineFrom(Form f) {
        Action res = INDEX.action;
        String command = f.getParameter(Params.JSP_COMMAND);
        if (command != null && !command.isEmpty())
            try {
                res = valueOf(command.toUpperCase()).action;
            } catch (Exception e) {
                res = ERROR.action;
            }
        return res;
    }

}
