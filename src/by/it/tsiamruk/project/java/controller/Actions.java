package by.it.tsiamruk.project.java.controller;



import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {{this.action = new CmdSignup();}},
    LOGIN {{this.action = new CmdLogin();}},
    LOGOUT {{this.action = new CmdLogout();}},
    ERROR {{this.action = new CmdError();}},
    CREATEACCOUNT{{this.action = new CmdCreateAccount();}};

    protected Action action;

    static Action defineFrom(HttpServletRequest req){
        String command = req.getParameter("command");
        Action res;
        try {
            res=Actions.valueOf(command.toUpperCase()).action;
        } catch (Exception e){
            res=Actions.ERROR.action;
        }
        return res;
    }



}