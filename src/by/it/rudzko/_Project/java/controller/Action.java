package by.it.rudzko._Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    private Action redirectTo;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.substring(3);
        return name;
    }

    public String getJsp() {
        String jsp = this.toString().toLowerCase().concat(".jsp");
        return "/".concat(jsp);
    }

    abstract Action execute(HttpServletRequest req);


}
