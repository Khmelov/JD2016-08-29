package by.it.grishechkin.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yury on 10.11.2016.
 */
    public enum Actions {
        INDEX {{
            this.action = new CmdIndex();
        }},
        CREATEAUTO {{
            this.action = new CmdCreateAuto();
        }},
        SHOWAUTO {{
            this.action = new CmdShowAuto();
        }},
        CREATEORDER {{
             this.action = new CmdCreateOrder();
        }},
        SHOWORDER {{
              this.action = new CmdShowOrder();
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
        ADMIN {{
            this.action = new CmdAdmin();
        }},
        PAYORDER {{
            this.action = new CmdPay();
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
