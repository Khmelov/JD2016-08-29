package by.it.savelyeva.matlab;

import by.it.savelyeva.matlab.inout.Printer;

/**
 * Created by nato on 9/16/16.
 */
public class Error {
    public Error(String err) {
        Printer.printData("ERROR: " + err + ": ");
    }
}