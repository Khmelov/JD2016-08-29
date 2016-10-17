package by.it.savelyeva.matlab.test;

import by.it.savelyeva.matlab.Calc;
import by.it.savelyeva.matlab.VarDimensionException;
import by.it.savelyeva.matlab.test.vars.TestUtils;
import by.it.savelyeva.matlab.vars.Var;
import by.it.savelyeva.matlab.vars.VarFloat;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by nato on 10/12/16.
 */
public class CalcTest {

    @Test(expected = VarDimensionException.class)
    public void testCalculateAddVectorsDifferentDimensions() throws Exception {
        String expression = "{1,2}+{-3,5.0,5}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateAddMatricesDifferentDimensions() throws Exception {
        String expression = "{{1,2},{0,1.02}}+{{-3,5.0,5},{1,-1,2.2}}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateSubVectorsDifferentDimensions() throws Exception {
        String expression = "{1,2}-{-3,5.0,5}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateSubMatricesDifferentDimensions() throws Exception {
        String expression = "{{1,2},{0,1.02}}-{{-3,5.0,5},{1,-1,2.2}}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateMulMatricesDifferentDimensions() throws Exception {
        String expression = "{{-3,5.0},{1,-1}}*{{1,2},{0,1.02},{10.5,20.5}}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateMulVectorMatrixDifferentDimensions() throws Exception {
        String expression = "{1,2}*{{10,20,30},{-3,5.0,5},{1,-1,2.2}}";
        Calc.calculate(expression);
    }

    @Test(expected = VarDimensionException.class)
    public void testCalculateMulMatrixVectorDifferentDimensions() throws Exception {
        String expression = "{{10,20,30},{-3,5.0,5},{1,-1,2.2}}*{1,-1}";
        Calc.calculate(expression);
    }

    @Test
    public void testCalculateWithVariables() throws Exception {
        String[] expressions = new String[] {"V={1,2}-{3,5.5}", "{1,2}*{3,4}",
                "-2*(-3)*(-1)*({1,2}+({3,4}-{0,1}))+10/2+V+{{2,0},{0,2}}*{{1,1}}"};
        String[] results = new String[] {"[-2.0,-3.5]", "[11.0]", "[-19.0,-26.5]"};
        for (int i=0; i<expressions.length; i++) {
            String res = Calc.calculate(expressions[i]);
            assertTrue(res.compareTo(results[i]) == 0);
        }
    }

    @Test
    public void testCalculateNoVariables() throws Exception {
        String[] expressions = new String[] {"{1,2}-{3,5.5}", "{1,2}*{3,4}",
                "-2*(-3)*(-1)*({1,2}+({3,4}-{0,1}))+10/2+({1,2}-{3,5.5})+{{2,0},{0,2}}*{{1,1}}"};
        String[] results = new String[] {"[-2.0,-3.5]", "[11.0]", "[-19.0,-26.5]"};
        for (int i=0; i<expressions.length; i++) {
            String res = Calc.calculate(expressions[i]);
            assertTrue(res.compareTo(results[i]) == 0);
        }
    }

    @Test
    public void testRestoreCalcFileNotExist() throws Exception {
        String filename = "abcdefgh.";
        Calc c = Calc.restoreCalc(filename);
        assertTrue(c != null);
        assertTrue(c instanceof Calc);
        assertTrue(Calc.getCalcMap().size() == 0);  //i.e. FileNotFoundException is caught inside method,
                                                    // otherwise we would have it here
    }

    @Test
    public void testRestoreCalcFileExists() throws Exception {
        String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
        String filename = new Long(System.currentTimeMillis()).toString() + ".tmp";
        String path = src + filename;
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        writer.println("bb <-> 15.7\na <-> 17.0");
        writer.close();
        Calc c = Calc.restoreCalc(filename);
        File file = new File(path);
        assertTrue(file.delete());
        HashMap<String,Var> hm = Calc.getCalcMap();
        assertTrue(hm.size() == 2);
        assertTrue(TestUtils.doublesEqual(((VarFloat) hm.get("bb")).getValue(), 15.7));
        assertTrue(TestUtils.doublesEqual(((VarFloat) hm.get("a")).getValue(), 17.0));
    }

    @Test
    public void testBackupCalcMapNonempty() throws Exception {
        String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
        String filename = new Long(System.currentTimeMillis()).toString() + ".tmp";
        String path = src + filename;
        HashMap<String,Var> map = new HashMap<>();
        map.put("a", new VarFloat(17));
        map.put("bb", new VarFloat(15.7));
        Calc c = new Calc(map);
        c.backupCalc(filename);
        String[] expectedLines = new String[] {"bb <-> 15.7", "a <-> 17.0"};
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            while ((line = bufferReader.readLine()) != null) {
                assertTrue(line.trim().equals(expectedLines[i]));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(path);
        assertTrue(file.exists());
        assertTrue(file.delete());
    }

    @Test
    public void testBackupCalcMapEmpty() throws Exception {
        String src = System.getProperty("user.dir").concat("/src/by/it/savelyeva/matlab/");
        String filename = new Long(System.currentTimeMillis()).toString() + ".tmp";
        String path = src + filename;
        HashMap<String,Var> map = new HashMap<>();
        Calc c = new Calc(map);
        c.backupCalc(filename);
        File file = new File(path);
        assertTrue(file.exists());
        assertTrue(file.length() == 0);
        assertTrue(file.delete());
    }

}