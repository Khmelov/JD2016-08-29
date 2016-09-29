package by.it.sukora.jd01_11.HomeWork;

import jd01_11.HomeWork.inout.Printer;


public class Error {
    public Error(String err) {
        Printer.printData("ERROR: " + err + ": ");
    }
}