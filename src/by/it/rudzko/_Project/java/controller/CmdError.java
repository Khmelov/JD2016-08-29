package by.it.rudzko._Project.java.controller;

import by.it.rudzko._Project.java.Strings.Messages;

/**
 * @author Olga Rudzko
 */
class CmdError extends Action {

    /**
     * informs that page doesn't exist
     *
     * @param f contains servlet request and servlet response
     * @return null
     * @see Form
     */
    @Override
    Action execute(Form f) {
        f.setError(Messages.NO_PAGE);
        return null;
    }
}
