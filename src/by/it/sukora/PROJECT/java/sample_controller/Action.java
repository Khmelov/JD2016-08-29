package by.it.sukora.PROJECT.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sukora Stas.
 */
public abstract class Action {
    private Action redirectTo;

    //CmdName - CmdLogin -> /login.jsp
    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd", "");
        return name;
    }

    public String getJsp() {
        String jsp = this.toString().toLowerCase().concat(".jsp");
        return "/".concat(jsp);
    }

    abstract Action execute(HttpServletRequest req);
}
