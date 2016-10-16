package by.it.rudzko.jd01_09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserVecTest {
    @Test
    public void goVecAdd() throws Exception {
        Parser p=new Parser("{23,4,17}+{0,6,10}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{23, 10, 27}", s);
    }

    @Test
    public void goVecSub() throws Exception {
        Parser p=new Parser("{6,3,56}-{1,45,2}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{5, -42, 54}", s);
    }

    @Test
    public void goVecMul() throws Exception {
        Parser p=new Parser("{6,3}*{1,2}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("12.0", s);
    }

    @Test
    public void goVecDiv() throws Exception {
        Parser p=new Parser("{24,15}*{6,5}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{4, 3}", s);
    }

    @Test
    public void goVecAddNum() throws Exception {
        Parser p=new Parser("{2, 7}+4");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{6.0, 11.0}", s);
    }

    @Test
    public void goVecSubNum() throws Exception {
        Parser p = new Parser("{9,3,34}/2");
        p.go();
        String s = p.getResult().toString();
        assertEquals("{4.5, 1.5, 17.0}", s);
    }

    @Test
    public void goVecMulNum() throws Exception {
        Parser p=new Parser("{6,3}*4");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{24.0, 12.0}", s);
    }

    @Test
    public void goVecDivNum() throws Exception {
        Parser p=new Parser("{27,15}/3");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{4.0, 5.0}", s);
    }
}