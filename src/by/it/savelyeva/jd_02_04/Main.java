package by.it.savelyeva.jd_02_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by nato on 10/12/16.
 */
public class Main {

    private static final String patternHexNumber = "0(x|X)[0-9a-fA-F]+";

    public static String findAllJavaHexNumbers(String line) {
        StringBuilder res = new StringBuilder("");
        Pattern pattern = Pattern.compile(patternHexNumber);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            res.append(matcher.group()).append("\n");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Task A from workbook: in a string find all numbers in Java HEX format.");
        String line = "0xAB asd 0AB 0X1111 0xfffff ABC";
        System.out.println(findAllJavaHexNumbers(line));

        System.out.println("Task A, B, C: add parsing commands feature to matlab project, add jUnit tests.");
        System.out.println("(this is solved in by.it.savelyeva.matlab)");
    }

}
