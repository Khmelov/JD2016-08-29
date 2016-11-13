package by.it.grishechkin.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yury on 12.11.2016.
 */
public abstract class Action {
    private Action redirectTo;

    @Override
    public String toString() {
        String name=this.getClass().getSimpleName();
        name=name.replace("Cmd","");
        return name;
    }

    public String getJsp(){
        String jsp=this.toString().toLowerCase().concat(".jsp");
        return "/".concat(jsp);
    }

    abstract Action execute(HttpServletRequest req);
}
