package by.it.savelyeva.matlab.test.vars;

import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/12/16.
 */
public class VarFloatTest {

    @Test
    public void testAdd() throws Exception {
        Var value1 = new VarFloat(5);
        Var value2 = new VarFloat(-10.3);
        Double expected = -5.3;
        Var res = value1.add(value2);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testSub() throws Exception {
        Var value1 = new VarFloat(5);
        Var value2 = new VarFloat(-10.3);
        Double expected = 15.3;
        Var res = value1.sub(value2);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testMul() throws Exception {
        Var value1 = new VarFloat(5);
        Var value2 = new VarFloat(-10.3);
        Double expected = -51.5;
        Var res = value1.mul(value2);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testDiv() throws Exception {
        Var value1 = new VarFloat(5);
        Var value2 = new VarFloat(-10.3);
        Double expected = -0.4854368932;
        Var res = value1.div(value2);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testToString() throws Exception {
        VarFloat value = new VarFloat(-5.2);
        assertTrue(value.toString().compareTo("-5.2") == 0);
    }

    @Test
    public void testToStringFormatted() throws Exception {
        VarFloat value = new VarFloat(-5.2);
        assertTrue(value.toString("%8.4f").compareTo(" -5.2000") == 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testFromStringEmpty() throws Exception {
        String s = "";
        VarFloat.fromString(s);
    }

    @Test
    public void testFromStringNegativeHasFractionPart() throws Exception {
        String s = "-12.345";
        Double expected = Double.parseDouble(s);
        Var res = VarFloat.fromString(s);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testFromStringNegativeNoFractionPart() throws Exception {
        String s = "-1";
        Double expected = Double.parseDouble(s);
        Var res = VarFloat.fromString(s);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testFromStringPositiveHasFractionPart() throws Exception {
        String s = "0.3";
        Double expected = Double.parseDouble(s);
        Var res = VarFloat.fromString(s);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testFromStringPositiveNoFractionPart() throws Exception {
        String s = "10";
        Double expected = Double.parseDouble(s);
        Var res = VarFloat.fromString(s);
        assertTrue(res instanceof VarFloat);
        Double actual = ((VarFloat) res).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

}