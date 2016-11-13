package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nato on 11/2/16.
 */
public enum Actions {
    INDEX {{
        this.action = new CmdIndex();
    }},
    CREATERENT {{
        this.action = new CmdCreateRent();
    }},
    SHOWUSERS {{
        this.action = new CmdShowUsers();
    }},
    SHOWROLES {{
        this.action = new CmdShowRoles();
    }},
    SHOWRENTS {{
        this.action = new CmdShowRents();
    }},
    SHOWADDRESSES {{
        this.action = new CmdShowAddresses();
    }},
    SHOWCOUNTRIES {{
        this.action = new CmdShowCountries();
    }},
    SHOWCITIES {{
        this.action = new CmdShowCities();
    }},
    SHOWSTREETS {{
        this.action = new CmdShowStreets();
    }},
    SHOWSEXTYPES {{
        this.action = new CmdShowSexTypes();
    }},
    SHOWDRIVERLICENSES {{
        this.action = new CmdShowDriverLicenses();
    }},
    SHOWDLCATEGORIES {{
        this.action = new CmdShowDlCategories();
    }},
    SHOWCARS {{
        this.action = new CmdShowCars();
    }},
    SHOWMANUFACTURERS {{
        this.action = new CmdShowManufacturers();
    }},
    SHOWMODELS {{
        this.action = new CmdShowModels();
    }},
    SHOWTRANSMISSIONS {{
        this.action = new CmdShowTransmissions();
    }},
    SHOWCOLORS {{
        this.action = new CmdShowColors();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    LOGOUT {{
        this.action = new CmdLogout();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    ERROR {{
        this.action = new CmdError();
    }},
    SUCCESS {{
        this.action = new CmdSuccess();
    }},
    ;

    protected Action action = null;

    static Action defineFrom(HttpServletRequest req) {
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
