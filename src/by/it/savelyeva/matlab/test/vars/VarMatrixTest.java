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
public class VarMatrixTest {

    @Test(expected = VarDimensionException.class)
    public void testAddTwoMatricesDimensionsNotMatch() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5, 0}, {9.2, -0.1, 11}};
        double[][] v2 = new double[][] {{-2, 2.8}, {1.1, 2.2}, {-1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        value1.add(value2);
    }

    @Test
    public void testAddTwoMatrices() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5}, {0.5, 0.1}, {9.2, -0.1}};
        double[][] v2 = new double[][] {{-2, 2.8}, {1.1, 2.2}, {-1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        double[][] expected = new double[][] {{-1, 1.3}, {1.6, 2.3}, {8.1, -2.4}};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testAddMatrixVector() throws Exception {
        double[][] v1 = new double[][] {{-2, 2.8}, {1, -1}};
        double[] v2 = new double[] {1, -1.5, 0};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarVector(v2);
        Var res = value1.add(value2);
        assertTrue(res == null);
    }

    @Test
    public void testAddScalarMatrix() throws Exception {
        double v1 = 5.2;
        double[][] v2 = new double[][] {{-2, 0.1, 2.8}, {0.5, 4.4, -1}};
        Var value1 = new VarFloat(v1);
        Var value2 = new VarMatrix(v2);
        double[][] expected = new double[][] {{3.2, 5.3, 8}, {5.7, 9.6, 4.2}};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testAddMatrixScalar() throws Exception {
        double[][] v1 = new double[][] {{-2, 0.1, 2.8}, {0.5, 4.4, -1}};
        double v2 = 5.2;
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarFloat(v2);
        double[][] expected = new double[][] {{3.2, 5.3, 8}, {5.7, 9.6, 4.2}};
        Var res = value1.add(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test(expected = VarDimensionException.class)
    public void testSubTwoMatricesDimensionsNotMatch() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5, 0}, {9.2, -0.1, 11}};
        double[][] v2 = new double[][] {{-2, 2.8}, {1.1, 2.2}, {-1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        value1.sub(value2);
    }

    @Test
    public void testSubTwoMatrices() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5}, {0.5, 0.1}, {9.2, -0.1}};
        double[][] v2 = new double[][] {{-2, 2.8}, {1.1, 2.2}, {-1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        double[][] expected = new double[][] {{3, -4.3}, {-0.6, -2.1}, {10.3, 2.2}};
        Var res = value1.sub(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testSubScalarMatrix() throws Exception {
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
    public void testSubMatrixScalar() throws Exception {
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

    @Test
    public void testSubMatrixVector() throws Exception {
        double[][] v1 = new double[][] {{-2, 2.8}, {1, -1}};
        double[] v2 = new double[] {1, -1.5, 0};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarVector(v2);
        Var res = value1.sub(value2);
        assertTrue(res == null);
    }

    @Test(expected = VarDimensionException.class)
    public void testMulTwoMatricesDimensionsNotMatch() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5}, {0.5, 0.1}};
        double[][] v2 = new double[][] {{-2, 2.8}, {1.1, 2.2}, {-1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        value1.mul(value2);
    }

    @Test
    public void testMulTwoMatrices() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5}, {0.5, 0.1}, {9.2, -0.1}};
        double[][] v2 = new double[][] {{-2, 2.8, 1.1}, {2.2, -1.1, -2.3}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        double[][] expected = new double[][] {{-5.3, 4.45, 4.55}, {-0.78, 1.29, 0.32}, {-18.62, 25.87, 10.35}};
        Var res = value1.mul(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testMulMatrixVector() throws Exception {
        double[][] v1 = new double[][] {{-2, 2.8}, {1, 1}};
        double[] v2 = new double[] {1,-1.5};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarVector(v2);
        double[] expected = new double[] {-6.2, -0.5};
        Var res = value1.mul(value2);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test(expected = VarDimensionException.class)
    public void testMulMatrixVectorDimensionsNotMatch() throws Exception {
        double[][] v1 = new double[][] {{-2, 2.8, 1}, {1, 1, -1}, {0.9, 1.5, -9}};
        double[] v2 = new double[] {1, -1.5};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarVector(v2);
        value1.mul(value2);
    }

    @Test
    public void testDivTwoMatrices() throws Exception {
        double[][] v1 = new double[][] {{1, -1.5}, {1, -1}};
        double[][] v2 = new double[][] {{-2, 2.8}, {-2, 2}};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarMatrix(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivMatrixVector() throws Exception {
        double[][] v1 = new double[][] {{-2, 2.8}, {0, 1.1}};
        double[] v2 = new double[] {1, -1.5};
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarVector(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivScalarMatrix() throws Exception {
        double v1 = 5.2;
        double[][] v2 = new double[][] {{-2, 0.1, 2.8}, {1, -1, 1}};
        Var value1 = new VarFloat(v1);
        Var value2 = new VarMatrix(v2);
        Var res = value1.div(value2);
        assertTrue(res == null);
    }

    @Test
    public void testDivMatrixScalar() throws Exception {
        double[][] v1 = new double[][] {{-2, 0.1, 2.8}, {1, -1, 1}};
        double v2 = -2.0;
        Var value1 = new VarMatrix(v1);
        Var value2 = new VarFloat(v2);
        double[][] expected = new double[][] {{1, -0.05, -1.4}, {-0.5, 0.5, -0.5}};
        Var res = value1.div(value2);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testToString() throws Exception {
        double[][] values = new double[][] {{1.1, 0}, {-15, -2.2}};
        VarMatrix matrix = new VarMatrix(values);
        assertTrue(matrix.toString().compareTo("[[1.1,0.0],[-15.0,-2.2]]") == 0);
    }

    @Test(expected = NumberFormatException.class)
    public void testFromStringEmpty() throws Exception {
        String s = "";
        VarMatrix.fromString(s);
    }

    @Test
    public void testFromStringMatrixOneElement() throws Exception {
        String s = "{{1.2}}";
        double[] expected = new double[] {1.2};
        Var res = VarVector.fromString(s);
        assertTrue(res instanceof VarVector);
        double[] actual = ((VarVector) res).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testFromStringMatrixSomeElements() throws Exception {
        String s = "{1.2,10},{-3.05,14}";
        double[][] expected = new double[][] {{1.2, 10}, {-3.05, 14}};
        Var res = VarMatrix.fromString(s);
        assertTrue(res instanceof VarMatrix);
        double[][] actual = ((VarMatrix) res).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

}