package by.it.artiuschik.jd_02_04.mathlab.tests;

import by.it.artiuschik.jd_02_04.mathlab.errors.IncorrectBracketsException;
import by.it.artiuschik.jd_02_04.mathlab.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestParserVarF {
    //операции со скалярами
    private boolean parse(String expression,String result) throws IncorrectBracketsException {
        return new Parser().calc(expression).toString().equals(result);
    }

    @Test
    public void testAdd() throws Exception{
        assertTrue("Не работает сложение", parse("2+2","4.0"));
    }
    @Test
    public void testMul() throws Exception{
        assertTrue("Не работает умножение", parse("2*3","6.0"));

    }
    @Test
    public void testSub() throws Exception{
        assertTrue("Не работает вычитание", parse("6-2","4.0"));

    }
    @Test
    public void testDiv() throws Exception{
        assertTrue("Не работает деление", parse("8/2","4.0"));

    }
    @Test
    public void calcBigExpression() throws Exception {
        assertTrue("Не работает парсинг", parse("18+90/8+6*9+12-9","86.25"));
    }

}
