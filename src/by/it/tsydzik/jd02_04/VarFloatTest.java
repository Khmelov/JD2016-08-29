package by.it.tsydzik.jd02_04;

import by.it.tsydzik.mathlab.vars.Var;
import by.it.tsydzik.mathlab.vars.VarFloat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Eugene Tsydzik
 * @since 10.10.2016.
 */
public class VarFloatTest {
    @Test
    public void testAdd() throws Exception {
        VarFloat firstElem = new VarFloat("2");
        VarFloat secondElem = new VarFloat("5.3");
        String strResult = firstElem.add(secondElem).toString();
        String expectedResult = new VarFloat("7.3").toString();
        assertEquals("Ошибка сложения", expectedResult, strResult);
    }

    @Test
    public void testSub() throws Exception {
        VarFloat firstElem = new VarFloat("25.55");
        VarFloat secondElem = new VarFloat("0.55");
        String strResult = firstElem.sub(secondElem).toString();
        String expectedResult = new VarFloat("25").toString();
        assertEquals("Ошибка вычитания", expectedResult, strResult);
    }

    @Test
    public void testMul() throws Exception {
        VarFloat firstElem = new VarFloat("7.3");
        VarFloat secondElem = new VarFloat("3.5");
        String strResult = firstElem.mul(secondElem).toString();
        String expectedResult = new VarFloat("25.55").toString();
        assertEquals("Ошибка умножения", expectedResult, strResult);
    }

    @Test
    public void testDiv() throws Exception {
        VarFloat firstElem = new VarFloat("7.3");
        VarFloat secondElem = new VarFloat("2");
        String strResult = firstElem.div(secondElem).toString();
        String expectedResult = new VarFloat("3.65").toString();
        assertEquals("Ошибка деления", expectedResult, strResult);
    }

}