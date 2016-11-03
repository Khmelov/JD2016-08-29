package by.it.tsydzik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eugene Tsydzik
 * @since 02.11.2016.
 */
public abstract class Action {
    private Action redirectTo;

    //CmdName - CmdLogin -> /login.jsp
    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        return name.replace("Cmd", "");
    }

    public String getJsp() {
        return "/".concat(this.toString().toLowerCase().concat(".jsp"));
    }

    abstract Action execute(HttpServletRequest req);
}
