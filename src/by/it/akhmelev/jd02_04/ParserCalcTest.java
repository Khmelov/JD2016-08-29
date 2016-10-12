package by.it.akhmelev.jd02_04;

import by.it.akhmelev.jd02_04.matlab_with_parser.*;
import by.it.akhmelev.jd02_04.matlab_with_parser.vars.Var;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10.10.2016.
 */
public class ParserCalcTest {
    @Test
    public void calc() throws Exception {
        Parser p=new Parser();
        Var var=p.calc("1+2-9*89-4+8+{1,2,3}");
        Boolean res=var.toString().equals("{-793.0, -792.0, -791.0}");
        assertTrue("Parcer Calc Error",res);

    }

}