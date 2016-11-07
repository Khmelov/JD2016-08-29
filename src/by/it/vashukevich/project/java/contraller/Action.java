package by.it.vashukevich.project.java.contraller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    private Action redirectTo;

    //CndName - CmdLogin ->/login.jsp
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
