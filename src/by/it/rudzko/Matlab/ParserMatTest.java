package by.it.rudzko.Matlab;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserMatTest {
    @Test
    public void goMatAdd() throws Exception {
        Parser p=new Parser("{{2,3}, {6,10}}+{{1,0}, {4,28}}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{3.0, 3.0}, {10.0, 38.0}}", s);
    }

    @Test
    public void goMatSub() throws Exception {
        Parser p=new Parser("{{12,6}, {6,5}}-{{5,1}, {4,5}}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{7.0, 5.0}, {2.0, 0.0}}", s);
    }

    @Test
    public void goMatMul() throws Exception {
        Parser p=new Parser("{{4,3}, {5,12}}*{{1,0}, {4,2}}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{16.0, 6.0}, {53.0, 24.0}}", s);
    }

    @Test
    public void goMatDiv() throws Exception {
        Parser p=new Parser("{{4,3}, {5,12}}/{{1,0}, {4,2}}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("Err:Деление невозможно", s);
    }

    @Test
    public void goMatAddNum() throws Exception {
        Parser p=new Parser("{{1,4}, {6,12}}+4");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{5.0, 4.0}, {6.0, 16.0}}", s);
    }

    @Test
    public void goMatAddVec() throws Exception {
        Parser p=new Parser("{{3,5}, {2,6}}+{14,8}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("ERR:Сложение невозможно", s);
    }

    @Test
    public void goMatSubNum() throws Exception {
        Parser p=new Parser("{{3,5}, {2,6}}-3");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{0.0, 5.0}, {2.0, 3.0}}", s);
    }

    @Test
    public void goMatMulNum() throws Exception {
        Parser p=new Parser("{{3,1}, {4,1}}*10");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{30.0, 10.0}, {40.0, 10.0}}", s);
    }

    @Test
    public void goMatDivNum() throws Exception {
        Parser p=new Parser("{{3,5}, {2,5}}/2");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{1.5, 2.5}, {1.0, 2.5}}", s);
    }

    @Test
    public void goMatDivVec() throws Exception {
        Parser p=new Parser("{{2,3}, {2,6}}/{1,2}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("ERR:Деление невозможно", s);
    }

    @Test
    public void goMatMulVec() throws Exception {
        Parser p=new Parser("{{3,1}, {4,1}}*{1,1}");
        p.go();
        String s=p.getResult().toString();
        assertEquals("{{30.0, 10.0}, {40.0, 10.0}}", s);
    }


}