package by.it.tsiamruk.project.java.controller;



import javax.servlet.http.HttpServletRequest;

enum Actions {
    INDEX{{this.action = new CmdIndex();}},
    SIGNUP {{this.action = new CmdSignup();}},
    LOGIN {{this.action = new CmdLogin();}},
    LOGOUT{{this.action = new CmdLogout();}},
    CREATEPROFILE {{this.action = new CmdCreateProfile();}},
    PROFILE {{this.action = new CmdProfile();}},
    CREATEACCOUNT{{this.action = new CmdCreateAccount();}},
    SHOWACCOUNTS {{this.action = new CmdShowAccounts();}},
    ERROR {{this.action = new CmdError();}};

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