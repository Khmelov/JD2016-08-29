package by.it.savelyeva.jd_01_06;

/**
 * Created by nato on 9/12/16.
 */
public class TaskB2 {

    public static StringBuilder sortStatements(String[] statements) {
        int last = statements.length - 1;
        boolean sorted;
        do {
            sorted = true;
            for (int i=0; i<statements.length-1; i++) {
                if (Util.splitToWords(statements[i], false).length > Util.splitToWords(statements[i+1], false).length) {
                    String tmp = statements[i];
                    statements[i] = statements[i+1];
                    statements[i+1] = tmp;
                    sorted = false;
                }
            }
            last--;
        } while (last>0);

        StringBuilder sb = new StringBuilder("");
        for (String s: statements) {
            sb.append(s.replace("\n", " ") + "\n");
        }
        return sb;
    }
}
