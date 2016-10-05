package by.it.savelyeva.jd_01_09;

import by.it.savelyeva.jd_01_09.inout.Parser;

/**
 * Created by nato on 9/16/16.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Multiple operations in a string not yet supported.
         */

        // Demo of:
        // - new operation "=" (assignment) is working,
        // - printvar, sortvar commands work, and
        // - no regression occurs (if needed, uncomment detailedDemo() call below)
        String[] taskA = new String[] {"a=5", "b=-9", "3.8+26.2", "87.4-23.1", "1.04*5.9", "12.7*5", "-6+12", "-7*3.1", "-4/8", "-9-0.9"};
        String[] taskB = new String[] {"d={2,-3,4}", "{2,3,4}*2", "{2,3,4}/3", "{2,3,4}-5", "-4+{2,3,4}", "{2,3,4}+{5,6,7}", "{2,3,4}-{5,6,7}"};
        String[] taskC = new String[] {"c={{1,2},{-8,3}}", "{{1,2},{8,3}}-2", "{{1,2},{8,3}}*{1,2}", "{{1,2},{8,3}}*{{1,2},{8,3}}", "{{1,2},{8,3}}+{{1,2},{8,3}}"};

        Calc c = new Calc();
        for (String expression: taskA) c.calculate(expression);
        for (String expression: taskB) c.calculate(expression);
        for (String expression: taskC) c.calculate(expression);

        Parser.parseConsoleCommand(c);

        //detailedDemo();

    }

    public static void detailedDemo() {
        Calc c = new Calc();

        // Below are just more checks, including impossible operations
        String v2 = "[1,2]";
        String v3 = "[1,2,3]";
        String m33 = "[[1,2,3],[0,4,5],[0,0,6]]";
        String m32 = "[[1,2],[0,4],[5,6]]";
        String m23 = "[[1,2,3],[4,5,6]]";
        String[] myInputsScalars = new String[] {"1+2", "9-7", "1.5*29", "-4/-1"};
        String[] myInputsVectorScalar = new String[] {v2+"+2", v3+"-1", v3+"*2", v2+"/1"};
        String[] myInputsScalarVector = new String[] {"1+"+v2, "2-"+v3, "1*"+v3, "2/"+v2};
        String[] myInputsVectors = new String[] {v2+"+"+v2, v3+"-"+v3, v2+"*"+v2, //possible
                v3+"/"+v3, v3+"+"+v2, v2+"-"+v3, v2+"*"+v3, v3+"/"+v2};//impossible
        String[] myInputsMatrixScalar = new String[] {m33+"+2", m32+"-1", m23+"*2", m33+"/-2"};
        String[] myInputsScalarMatrix = new String[] {"2+"+m33, "1-"+m32, "2*"+m23, "-2/"+m33};
        String[] myInputsMatrixVector = new String[] {m23+"*"+v3, //possible
                m33+"+"+v3, m32+"-"+v2, m23+"*"+v2, m33+"/"+v3};//impossible
        String[] myInputsVectorMatrix = new String[] {v2+"*"+m23, //possible
                v3+"+"+m33, v2+"-"+m32, v3+"*"+m23, v2+"/"+m33};//impossible
        String[] myInputsMatrices = new String[] {m33+"+"+m33, m23+"+"+m23, m33+"-"+m33, m32+"-"+m32, m33+"*"+m33,//possible
                m23+"+"+m32, m33+"-"+m32, m23+"*"+m23, m33+"/"+m33,};//impossible


        System.out.println("Opeartions with two scalars:");
        for (String expression: myInputsScalars) c.calculate(expression);

        System.out.println("Operations vector at left and scalar at right:");
        for (String expression: myInputsVectorScalar) c.calculate(expression);

        System.out.println("Operations scalar at left and vector at right:");
        for (String expression: myInputsScalarVector) c.calculate(expression);

        System.out.println("Operations with two vectors:");
        for (String expression: myInputsVectors) c.calculate(expression);

        System.out.println("Operations matrix at left and scalar at right:");
        for (String expression: myInputsMatrixScalar) c.calculate(expression);

        System.out.println("Operations scalar at left and matrix at right:");
        for (String expression: myInputsScalarMatrix) c.calculate(expression);

        System.out.println("Operations matrix at left and vector at right:");
        for (String expression: myInputsMatrixVector) c.calculate(expression);

        System.out.println("Operations vector at left and matrix at right:");
        for (String expression: myInputsVectorMatrix) c.calculate(expression);

        System.out.println("Operations with two matrices:");
        for (String expression: myInputsMatrices) c.calculate(expression);

    }
}