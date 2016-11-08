package by.it.tsiamruk.project.java.controller;



import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX{{this.action = new CmdIndex();}},
    SIGNUP {{this.action = new CmdSignup();}},
    LOGIN {{this.action = new CmdLogin();}},
    PROFILE {{this.action = new CmdProfile();}},
    ERROR {{this.action = new CmdIndex();}},
    CREATEACCOUNT{{this.action = new CmdCreateAccount();}},
    SHOWUSERS {{this.action = new CmdShowUsers();}};

    protected Action action;

    static Action defineFrom(HttpServletRequest req){
        String command = req.getParameter("command");
        Action res = INDEX.action;
        if (command!=null)
            try {
                res=Actions.valueOf(command.toUpperCase()).action;
            } catch (Exception e){
                res=ERROR.action;
            }
            return res;
    }



}