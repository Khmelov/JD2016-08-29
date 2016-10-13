package by.it.savelyeva.matlab.test.inout;

import by.it.savelyeva.matlab.inout.Parser;
import by.it.savelyeva.matlab.test.vars.TestUtils;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import by.it.savelyeva.matlab.vars.VarMatrix;
import by.it.savelyeva.matlab.vars.VarVector;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/12/16.
 */
public class ParserTest {

    @Test
    public void testIsSupportedOperationSupported() throws Exception {
        String[] operations = new String[] {"*", "/", "+", "-", "="};
        for (String operation: operations) {
            assertTrue(Parser.isSupportedOperation(operation));
        }
    }

    @Test
    public void testIsSupportedOperationNotSupported() throws Exception {
        String[] operations = new String[] {"(", ")", "a", "0"};
        for (String operation: operations) {
            assertTrue(!Parser.isSupportedOperation(operation));
        }
    }

    @Test
    public void testIsRegexpMatchedMatches() throws Exception {
        String pattern = "[0-9a-z]+";
        assertTrue(Parser.isRegexpMatched("a1", pattern));
    }

    @Test
    public void testIsRegexpMatchedNotMatch() throws Exception {
        String pattern = "[0-9a-z]+";
        assertTrue(!Parser.isRegexpMatched("0A1", pattern));
    }

    @Test
    public void testSortingStationMapEmpty() throws Exception {
        String expression = "5 + ((-1.2 + {2, -2}) * A) - {{3,-1},{-1,-5.0}}";
        Map<String,Var> map = new HashMap<>();
        String strRversePolishNotation = Parser.sortingStation(expression, map);
        // below "~" can be replaced with Parser.unarMinus, but left as is for convenience
        assertTrue(strRversePolishNotation.equals("5 -1.2 {2,-2} + A * + {{3,-1},{-1,-5.0}} -"));
        assertTrue(map.get("A") == null);
    }

    @Test
    public void testSortingStationMapNotEmpty() throws Exception {
        String expression = "B = 5 + ((-1.2 + {2, -2}) * A) - {{3,-1},{-1,-5.0}}";
        Map<String,Var> map = new HashMap<>();
        VarFloat value = new VarFloat(-10.2);
        map.put("C", value);
        String strRversePolishNotation = Parser.sortingStation(expression, map);
        // below "~" can be replaced with Parser.unarMinus, but left as is for convenience
        assertTrue(strRversePolishNotation.equals("B 5 -1.2 {2,-2} + A * + {{3,-1},{-1,-5.0}} - ="));
        assertTrue(map.get("A") == null);
        assertTrue(map.get("B") == null);
        assertTrue(map.get("C") == value);
    }

    @Test
    public void testParseOneVarFloat() throws Exception {
        double expected = -1.12;
        Var value = Parser.parseOneVar("-1.12");
        assertTrue(value instanceof VarFloat);
        double actual = ((VarFloat) value).getValue();
        assertTrue(TestUtils.doublesEqual(actual, expected));
    }

    @Test
    public void testParseOneVarVector() throws Exception {
        double[] expected = {-1.12, 10};
        Var value = Parser.parseOneVar("{-1.12,10}");
        assertTrue(value instanceof VarVector);
        double[] actual = ((VarVector) value).getValue();
        assertTrue(TestUtils.vectorsEqual(actual, expected));
    }

    @Test
    public void testParseOneVarMatrix() throws Exception {
        double[][] expected = {{0, 1},{-1.12, 10}};
        Var value = Parser.parseOneVar("{0,1},{-1.12,10}}");
        assertTrue(value instanceof VarMatrix);
        double[][] actual = ((VarMatrix) value).getValue();
        assertTrue(TestUtils.matricesEqual(actual, expected));
    }

    @Test
    public void testParseConsoleCommand() throws Exception {
        //TODO: add test
    }

    @Test
    public void testReadFileNotExist() throws Exception {
        String filename = "abcdefgh.";
        HashMap<String,Var> hm = Parser.readFile(filename);
        assertTrue(hm.size() == 0); //i.e. FileNotFoundException is caught inside method otherwise we would have it here
    }

    @Test
    public void testReadFileExists() throws Exception {
        String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
        String filename = new Long(System.currentTimeMillis()).toString() + ".tmp";
        String path = src + filename;
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println("bb <-> 15.7\na <-> 17.0");
        writer.close();
        HashMap<String,Var> hm = Parser.readFile(filename);
        assertTrue(hm.size() == 2);
        assertTrue(TestUtils.doublesEqual(((VarFloat) hm.get("bb")).getValue(), 15.7));
        assertTrue(TestUtils.doublesEqual(((VarFloat) hm.get("a")).getValue(), 17.0));
        File file = new File(path);
        assertTrue(file.delete());
    }

}