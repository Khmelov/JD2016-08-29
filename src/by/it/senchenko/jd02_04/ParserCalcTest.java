package by.it.senchenko.jd02_04;

import by.it.akhmelev.jd02_04.matlab_with_parser.Parser;
import by.it.akhmelev.jd02_04.matlab_with_parser.vars.Var;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ParserCalcTest {
    @Test
    public void calc() throws Exception {
        Parser p=new Parser();
        Var var=p.calc("1+2-9*89-4+8+{1,2,3}");
        Boolean res=var.toString().equals("{-793.0, -792.0, -791.0}");
        assertTrue("Parcer Calc Error",res);

    }

}