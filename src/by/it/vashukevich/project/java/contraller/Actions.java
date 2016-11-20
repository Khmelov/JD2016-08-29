package by.it.vashukevich.project.java.contraller;

import javax.servlet.http.HttpServletRequest;

public enum  Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    SHOWCOURSES{{
        this.action=new CmdShowCourses();
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

    protected Action action=null;

    static  Action defineFrom(HttpServletRequest req){
        String command=req.getParameter("command");
        Action res;
        try {
            res=Actions.valueOf(command.toUpperCase()).action;
        }catch (Exception e){
            res=Actions.ERROR.action;
        }
        return res;
    }
}
