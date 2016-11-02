package by.it.artiuschik.mathlab.tests;

import by.it.artiuschik.mathlab.errors.IncorrectBracketsException;
import by.it.artiuschik.mathlab.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestParserVarV {
    //операции с векторами
    private boolean parse(String expression,String result) throws Exception {
        return new Parser().calc(expression).toString().equals(result);
    }

    @Test
    public void testAdd() throws Exception{
        assertTrue("Не работает сложение", parse("{1.0,2.0,3.0}+{2.0,4.0,6.0}","{3.0, 6.0, 9.0}"));
    }
    @Test
    public void testMul() throws Exception{
        assertTrue("Не работает умножение", parse("{1.0,2.0,3.0}*3","{3.0, 6.0, 9.0}"));

    }
    @Test
    public void testSub() throws Exception{
        assertTrue("Не работает вычитание", parse("{1.0,2.0,3.0}-{2.0,3.0,4.0}","{-1.0, -1.0, -1.0}"));

    }
    @Test
    public void testDiv() throws Exception{
        assertTrue("Не работает деление", parse("{2.0,2.0,4.0}/2","{1.0, 1.0, 2.0}"));

    }
    @Test
    public void calcBigExpression() throws Exception {
        assertTrue("Не работает парсинг", parse("{4.0,8.0,16.0}/4+{1.0,1.0,1.0}","{2.0, 3.0, 5.0}"));
    }

}
