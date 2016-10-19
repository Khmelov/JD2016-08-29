package by.it.sukora.jd02_04.matlab_with_parser.tests;

import by.it.sukora.jd02_04.matlab_with_parser.Parser;
import by.it.sukora.jd02_04.matlab_with_parser.vars.VarF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sukora Stas on 13.10.2016.
 */
public class VarFTest {
    private boolean parse(String expression,String result) {
        return new Parser().calc(expression).toString().equals(result);
    }
    @Test
    public void add() throws Exception {
        VarF firstElem = new VarF("2");
        VarF secondElem = new VarF("5.3");
        String strResult = firstElem.add(secondElem).toString();
        String expectedResult = new VarF("7.3").toString();
        assertEquals("Ошибка сложения", expectedResult, strResult);
    }

    @Test
    public void sub() throws Exception {
        VarF firstElem = new VarF("25.55");
        VarF secondElem = new VarF("0.55");
        String strResult = firstElem.sub(secondElem).toString();
        String expectedResult = new VarF("25").toString();
        assertEquals("Ошибка вычитания", expectedResult, strResult);
    }

    @Test
    public void mul() throws Exception {
        VarF firstElem = new VarF("7.3");
        VarF secondElem = new VarF("3.5");
        String strResult = firstElem.mul(secondElem).toString();
        String expectedResult = new VarF("25.55").toString();
        assertEquals("Ошибка умножения", expectedResult, strResult);
    }

    @Test
    public void div() throws Exception {
        VarF firstElem = new VarF("7.3");
        VarF secondElem = new VarF("2");
        String strResult = firstElem.div(secondElem).toString();
        String expectedResult = new VarF("3.65").toString();
        assertEquals("Ошибка деления", expectedResult, strResult);
    }

}