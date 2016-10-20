package by.it.sukora.jd02_04.matlab_with_parser.tests;

import by.it.sukora.jd02_04.matlab_with_parser.Parser;
import by.it.sukora.jd02_04.matlab_with_parser.vars.Var;
import org.junit.Assert;

public class TestParser extends Assert{

    private boolean parse(String expression,String result) {
        return new Parser().calc(expression).toString().equals(result);
    }

    @org.junit.Test
    public void calcAdd() throws Exception {
        assertTrue("Не работает сложение", parse("2+2","4.0"));
    }
    @org.junit.Test
    public void calcSub() throws Exception {
        assertTrue("Не работает вычитание", parse("4-2","2.0"));
    }
    @org.junit.Test
    public void calcMul() throws Exception {
        assertTrue("Не работает умножение", parse("2*3","6.0"));
    }
    @org.junit.Test
    public void calcDiv() throws Exception {
        assertTrue("Не работает деление", parse("6/2","3.0"));
    }


    @org.junit.Test
    public void calcBigExpression() throws Exception {
        assertTrue("Не работает парсинг", parse("18+90/8+6*9+12-9","86.25"));
    }


    public static class VarM extends Var {
        //это просто пример ;)
        //класс создается по аналогии с VarV и VarF

        public VarM(String strVar) {
            //тут нужно реализовать создание матрицы
        }

        @Override
        public Var add(Var var) {
            System.out.println("Тест. Работает позднее связывание с VarM->ADD");
            return null;
        }
    }
}