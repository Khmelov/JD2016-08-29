package by.it.emelyanov.jd02_06.mathlab.error;

import by.it.emelyanov.jd02_06.mathlab.logger.Logger;

import java.io.IOException;

public class Error {
    Logger logger = Logger.getMyLoger();

    public Error(String err) {
        System.out.println("Ошибка:" + err);
        logger.writeInLog("Ошибка: "+err);
    }
}
