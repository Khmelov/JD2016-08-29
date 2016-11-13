package by.it.artiuschik.project2.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    SHOWUSERS {{
        this.action = new CmdShowUsers();
    }},
    SHOWTEST {{
        this.action = new CmdShowTest();
    }},
    FILLQUESTIONS {{
        this.action = new CmdFillQuestions();
    }},
    SHOWRESULT {{
        this.action = new CmdShowResult();
    }},
    ADDQUESTIONS {{
        this.action = new CmdAddQuestions();
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
    ADDQUESTION {{
        this.action = new CmdAddQuestion();
    }},
    CREATETEST {{
        this.action = new CmdCreateTest();
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
