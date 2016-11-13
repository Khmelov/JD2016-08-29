package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.Strings.ForToString;

/**
 * @author Olga Rudzko
 *         executes the command
 */
public abstract class Action {
    private Action redirectTo;

    /**
     * @return name of called command
     */
    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.substring(3);
        return name;
    }

    /**
     * @return name of jsp file
     */
    public String getJsp() {
        return '/' + this.toString().toLowerCase().concat(ForToString.JSP);
    }

    abstract Action execute(Form f);


}
