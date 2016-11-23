package by.it.artiuschik.project_Testing_system.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    //CmdName - CmdLogin -> /login.jsp
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
