package by.it.tsiamruk.jd02_04;

import by.it.tsiamruk.matlab.Parser;
import by.it.tsiamruk.matlab.vars.Var;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ParserCalcTest {
    @Test
    public void calc() throws Exception {
        Parser p = new Parser();
        Var var = p.calculation("1+2-9*89-4+8+{1,2,3}");
        Boolean res = var.toString().equals("{-793.0, -792.0, -791.0}");
        assertTrue("Parser Calc Error", res);
    }

    @Test
    public void calcMatrix() throws Exception {
        Parser p = new Parser();
        Var var = p.calculation("{(2,3,5),(1,2,3),(2,3,5)} * {1,2,3}");
        Boolean res = var.toString().equals("{5.0, 6.0, 15.0}");
        assertTrue("Parser calc Error", res);
    }

}