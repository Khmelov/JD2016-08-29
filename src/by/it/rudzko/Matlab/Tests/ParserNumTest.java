package by.it.rudzko.Matlab.Tests;

import by.it.rudzko.Matlab.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserNumTest {
    @Test
    public void goNumMul() throws Exception {
        Parser p=new Parser("6*8");
        p.goParse();
        String s=p.getResult().toString();
        assertEquals("48.0", s);
    }

    @Test
    public void goNumSub() throws Exception {
      Parser p=new Parser("19-9");
        p.goParse();
        String s=p.getResult().toString();
      assertEquals("10.0", s);

    }

    @Test
    public void goNumAdd() throws Exception {
        Parser p=new Parser("4+7");
        p.goParse();
        String s=p.getResult().toString();
        assertEquals("11.0", s);
    }

    @Test
    public void goNumDiv() throws Exception{
        Parser p=new Parser("121/11");
        p.goParse();
        String s=p.getResult().toString();
        assertEquals("11.0", s);
    }

    @Test
    public void goNumSubVec() throws Exception {
        Parser p=new Parser("1-{3,6}");
        p.goParse();
        String s=p.getResult().toString();
        assertEquals("{-2.0, -5.0}", s);

    }

    @Test
    public void goNumSubMat() throws Exception {
        Parser p=new Parser("{{3,1}, {4,1}}-6");
        p.goParse();
        String s=p.getResult().toString();
        assertEquals("{{-3.0, 1.0}, {4.0, -5.0}}", s);
    }
}