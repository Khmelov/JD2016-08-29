package by.it.savelyeva.jd_01_13.matlab;

import by.it.savelyeva.jd_01_13.matlab.inout.Printer;

/**
 * Created by nato on 9/16/16.
 */
public class Error {
    public Error(String err) {
        Printer.printData("ERROR: " + err + ": ");
    }
}