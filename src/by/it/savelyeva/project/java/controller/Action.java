package by.it.savelyeva.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nato on 11/2/16.
 */
public abstract class Action {

    private Action redirectTo;

    // CmdName - CmdLogin -> login.jsp
    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd", "");
        return name;
    }

    public String getJSP() {
        String jsp = this.toString().toLowerCase().concat(".jsp");
        return String.format("/%s", jsp);
    }

    abstract Action execute(HttpServletRequest req);

}
