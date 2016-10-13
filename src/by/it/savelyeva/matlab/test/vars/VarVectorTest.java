package by.it.savelyeva.matlab.test.vars;

import by.it.savelyeva.matlab.VarDimensionException;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import by.it.savelyeva.matlab.vars.VarMatrix;
import by.it.savelyeva.matlab.vars.VarVector;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/12/16.
 */
public class VarVectorTest {

    @Test(expected = VarDimensionException.class)
    public void testAddTwoVectorsDimensionsNotMatch() throws Exception {
        double[] v1 = new double[] {1, -1.5, 0};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        value1.add(value2);
    }

    @Test
    public void testAddTwoVectors() throws Exception {
        double[] v1 = new double[] {1, -1.5};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {-1, 1.3};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testAddVectorMatrix() throws Exception {
        double[] v1 = new double[] {1, -1.5, 0};
        double[][] v2 = new double[][] {{-2, 2.8}, {1, -1}};
        Var value1 = new VarVector(v1);
        Var value2 = new VarMatrix(v2);
        Var res = value1.add(value2);
        assertTrue(res == null);
    }

    @Test
    public void testAddScalarVector() throws Exception {
        double v1 = 5.2;
        double[] v2 = new double[] {-2, 0.1, 2.8};
        Var value1 = new VarFloat(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {3.2, 5.3, 8};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testAddVectorScalar() throws Exception {
        double[] v1 = new double[] {-2, 0.1, 2.8};
        double v2 = 5.2;
        Var value1 = new VarVector(v1);
        Var value2 = new VarFloat(v2);
        double[] expected = new double[] {3.2, 5.3, 8};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test(expected = VarDimensionException.class)
    public void testSubTwoVectorsDimensionsNotMatch() throws Exception {
        double[] v1 = new double[] {1, -1.5, 0};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        value1.sub(value2);
    }

    @Test
    public void testSubTwoVectors() throws Exception {
        double[] v1 = new double[] {1,-1.5};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {3,-4.3};
        Var res = value1.sub(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testSubVectorMatrix() throws Exception {
        double[] v1 = new double[] {1, -1.5, 0};
        double[][] v2 = new double[][] {{-2, 2.8}, {1, -1}};
        Var value1 = new VarVector(v1);
        Var value2 = new VarMatrix(v2);
        Var res = value1.sub(value2);
        assertTrue(res == null);
    }

    @Test
    public void testSubScalarVector() throws Exception {
        double v1 = 5.2;
        double[] v2 = new double[] {-2, 0.1, 2.8};
        Var value1 = new VarFloat(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {7.2, 5.1, 2.4};
        Var res = value1.sub(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testSubVectorScalar() throws Exception {
        double[] v1 = new double[] {-2, 0.1, 2.8};
        double v2 = 5.2;
        Var value1 = new VarVector(v1);
        Var value2 = new VarFloat(v2);
        double[] expected = new double[] {-7.2, -5.1, -2.4};
        Var res = value1.sub(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test(expected = VarDimensionException.class)
    public void testMulTwoVectorsDimensionsNotMatch() throws Exception {
        double[] v1 = new double[] {1, -1.5, 0};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        value1.mul(value2);
    }

    @Test
    public void testMulTwoVectors() throws Exception {
        double[] v1 = new double[] {1,-1.5};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {-6.2};
        Var res = value1.mul(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testMulVectorMatrix() throws Exception {
        double[] v1 = new double[] {1,-1.5};
        double[][] v2 = new double[][] {{-2, 2.8}, {1, 1}};
        Var value1 = new VarVector(v1);
        Var value2 = new VarMatrix(v2);
        double[] expected = new double[] {-3.5, 1.3};
        Var res = value1.mul(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test(expected = VarDimensionException.class)
    public void testMulVectorMatrixDimensionsNotMatch() throws Exception {
        double[] v1 = new double[] {1,-1.5, -1};
        double[][] v2 = new double[][] {{-2, 2.8, 1}, {1, 1, -1}};
        Var value1 = new VarVector(v1);
        Var value2 = new VarMatrix(v2);
        value1.mul(value2);
    }

    @Test
    public void testDivTwoVectors() throws Exception {
        double[] v1 = new double[] {1, -1.5};
        double[] v2 = new double[] {-2, 2.8};
        Var value1 = new VarVector(v1);
        Var value2 = new VarVector(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivVectorMatrix() throws Exception {
        double[] v1 = new double[] {1, -1.5};
        double[][] v2 = new double[][] {{-2, 2.8}, {0, 1.1}};
        Var value1 = new VarVector(v1);
        Var value2 = new VarMatrix(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivScalarVector() throws Exception {
        double v1 = 5.2;
        double[] v2 = new double[] {-2, 0.1, 2.8};
        Var value1 = new VarFloat(v1);
        Var value2 = new VarVector(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivVectorScalar() throws Exception {
        double[] v1 = new double[] {-2, 0.1, 2.8};
        double v2 = 5.2;
        Var value1 = new VarVector(v1);
        Var value2 = new VarFloat(v2);
        double[] expected = new double[] {-0.3846153846, 0.0192307692, 0.5384615384};
        Var res = value1.div(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testToString() throws Exception {
        double[] values = new double[] {1.1, 0, -15, -2.2};
        VarVector vector = new VarVector(values);
        assertTrue(vector.toString().compareTo("[1.1,0.0,-15.0,-2.2]") == 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testFromStringEmpty() throws Exception {
        String s = "";
        VarVector.fromString(s);
    }

    @Test
    public void testFromStringVectorOneElement() throws Exception {
        String s = "{1.2}";
        double[] expected = new double[] {1.2};
        Var res = VarVector.fromString(s);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testFromStringVectorSomeElements() throws Exception {
        String s = "{1.2,10}";
        double[] expected = new double[] {1.2, 10};
        Var res = VarVector.fromString(s);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

}