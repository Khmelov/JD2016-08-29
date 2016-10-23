package by.it.emelyanov.jd02_06.mathlab.tests;

import by.it.emelyanov.jd02_06.mathlab.parser.Parser;
import org.junit.Assert;

public class Test extends Assert {
    private boolean parse(String expression, String result) {
        return new Parser().calc(expression).toString().equals(result);
    }

    //Тесты операций со скалярами
    @org.junit.Test
    public void calcAddVarF() throws Exception {
        assertTrue("Не работает сложение", parse("2+2", "4.0"));
    }

    @org.junit.Test
    public void calcSubVarF() throws Exception {
        assertTrue("Не работает вычитание", parse("4-2", "2.0"));
    }

    @org.junit.Test
    public void calcMulVarF() throws Exception {
        assertTrue("Не работает умножение", parse("2*3", "6.0"));
    }

    @org.junit.Test
    public void calcDivVarF() throws Exception {
        assertTrue("Не работает деление", parse("6/2", "3.0"));
    }

    //Тесты операций со скалярами
    @org.junit.Test
    public void calcAddVarV() throws Exception {
        assertTrue("Не работает сложение", parse("{1,2,3} + {2,3,4}", "{3.0, 5.0, 7.0}"));
    }

    @org.junit.Test
    public void calcSubVarV() throws Exception {
        assertTrue("Не работает вычитание", parse("{1,2,3}-{2,3,4}", "{-1.0, -1.0, -1.0}"));
    }

    @org.junit.Test
    public void calcMulVarV() throws Exception {
        assertTrue("Не работает умножение", parse("{1,2,3} * {2,3,4}", "20.0"));
    }

    @org.junit.Test
    public void calcDivVarV() throws Exception {
        assertFalse("Не работает деление", parse("{1,2,3}/{2,3,4}", "Ошибка:Делениение невозможно"));
    }

    //Тесты скаляр справа и вектор слева
    @org.junit.Test
    public void calcAddVarV_VarF() throws Exception {
        assertTrue("Не работает сложение", parse("{3,5,6}+6", "{9.0, 11.0, 12.0}"));
    }

    @org.junit.Test
    public void calcSubVarV_VarF() throws Exception {
        assertTrue("Не работает вычитание", parse("{3,5,6}-6", "{-3.0, -1.0, 0.0}"));
    }

    @org.junit.Test
    public void calcMulVarV_VarF() throws Exception {
        assertTrue("Не работает умножение", parse("{3,5,6}*6", "{18.0, 30.0, 36.0}"));
    }

    @org.junit.Test
    public void calcDivVarV_VarF() throws Exception {
        assertTrue("Не работает деление", parse("{8,16,2}/2", "{4.0, 8.0, 1.0}"));
    }

    //Тесты вектор справа и скаляр слева
    @org.junit.Test
    public void calcAddVarF_VarV() throws Exception {
        assertTrue("Не работает сложение", parse("5+{2,3,4}", "{7.0, 8.0, 9.0}"));
    }

    @org.junit.Test
    public void calcSubVarF_VarV() throws Exception {
        assertTrue("Не работает вычитание", parse("5-{2,3,4}", "{3.0, 2.0, 1.0}"));
    }

    @org.junit.Test
    public void calcMulVarF_VarV() throws Exception {
        assertTrue("Не работает умножение", parse("5*{2,3,4}", "{10.0, 15.0, 20.0}"));
    }

    @org.junit.Test
    public void calcDivVarF_VarV() throws Exception {
        assertFalse("Не работает деление", parse("5/{2,3,4}", "Ошибка:Делениение невозможно"));
    }
}
