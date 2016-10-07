package by.it.savelyeva.jd_01_15;
/**
 * Created by nato on 9/30/16.
 */
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskBMain {
    /**
     *
     * @param args input params
     */
    private static final String patternMultiLineComments = "/\\*(?:.|[\r\n])*?\\*/";
    private static final String patternOneLineComments = "[/]{1}[/]{1}.+";

    private static StringBuilder readFileToStringBuilder(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                sb.append(line + "\n");

            }
            //System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static StringBuilder cutComments(StringBuilder sb) {
        String regex = "("+patternMultiLineComments+")|("+patternOneLineComments+")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sb);
        int pos = 0;
        while (matcher.find(pos)) {
            sb.delete(matcher.start(), matcher.end());
            pos = matcher.start();
        }
        return sb;
    }

    private static StringBuilder formatData(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        int n = 1;
        int i = 0;
        while (i < sb.length()) {
            int start = i;
            int end = sb.indexOf("\n", start);
            res.append(n).append(": ").append(sb.substring(start, end)).append("\n");
            n++;
            i = end + 1;
        }
        return res;
    }

    private static void printToConsole(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    private static void printToFile(String filename, StringBuilder sb) {
        try (PrintWriter printer = new PrintWriter(new FileWriter(filename))) {
            printer.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String src = System.getProperty("user.dir"); // get project path
        src = src.concat("/src/by/it/savelyeva/");   // get dir
        String filename = src + "jd_01_15/TaskBMain.java";     // get absolute file path


        StringBuilder sb = readFileToStringBuilder(filename);
        sb = cutComments(sb);
        sb = formatData(sb);
        printToConsole(sb);
        String newFilename = filename.replaceAll("\\.java",".txt");
        printToFile(newFilename, sb);
    }
}
