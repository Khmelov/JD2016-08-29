package by.it.tsydzik.jd02_04;

import by.it.tsydzik.mathlab.vars.Var;
import by.it.tsydzik.mathlab.vars.VarFloat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Eugene Tsydzik
 * @since 10.10.2016.
 */
public class VarFloatTest {
    @Test
    public void testAdd() throws Exception {
        assertEquals("Ошибка сложения", (new VarFloat("7.3")).toString(), (new VarFloat("2").add(new VarFloat("5.3"))).toString());
    }

    @Test
    public void testSub() throws Exception {
        assertEquals("Ошибка вычитания", (new VarFloat("25")).toString(), (new VarFloat("25.55").sub(new VarFloat("0.55"))).toString());
    }

    @Test
    public void testMul() throws Exception {
        assertEquals("Ошибка умножения", (new VarFloat("25.55")).toString(), (new VarFloat("7.3").mul(new VarFloat("3.5"))).toString());
    }

    @Test
    public void testDiv() throws Exception {

    }

}