package by.it.sukora.jd02_04.matlab_with_parser.tests;

import by.it.sukora.jd02_04.matlab_with_parser.IncorrectBracketsException;
import by.it.sukora.jd02_04.matlab_with_parser.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sukora Stas on 13.10.2016.
 */
public class VarVTest {
    private boolean parse(String expression, String result) throws IncorrectBracketsException {
        return new Parser().calc(expression).toString().equals(result);
    }

    @Test
    public void add() throws Exception {
        assertTrue("Не работает сложение", parse("{1.0,2.0,3.0}+{2.0,4.0,6.0}", "{3.0, 6.0, 9.0}"));
    }

    @Test
    public void sub() throws Exception {
        assertTrue("Не работает вычитание", parse("{1.0,2.0,3.0}-{2.0,3.0,4.0}", "{-1.0, -1.0, -1.0}"));

    }

    @Test
    public void mul() throws Exception {
        assertTrue("Не работает умножение", parse("{1.0,2.0,3.0}*3", "{3.0, 6.0, 9.0}"));
    }

    @Test
    public void div() throws Exception {
        assertTrue("Не работает деление", parse("{2.0,2.0,4.0}/2","{1.0, 1.0, 2.0}"));
    }

}