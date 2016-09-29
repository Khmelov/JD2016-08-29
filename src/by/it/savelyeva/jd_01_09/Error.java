package by.it.savelyeva.jd_01_09;

import by.it.savelyeva.jd_01_09.inout.Printer;

/**
 * Created by nato on 9/16/16.
 */
public class Error {
    public Error(String err) {
        Printer.printData("ERROR: " + err + ": ");
    }
}