package by.it.emelyanov.jd01_15;

import java.io.*;

public class TaskB {

    /**
     * Комментарий
     */

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/emelyanov/jd01_15/";
        File fileMain = new File(src + "TaskB.java");
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileMain))) {
                //комментарий
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    line = line.replaceAll("(/\\*{1,2}.*)|(\\*{1}.*)|//.*", "");
                    stringBuilder.append(String.format("%2d", count++) + ": " + line + "\n");
                }
            }
             /* комментарий */
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());

        File file = new File(src + "TaskB.txt");

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            printWriter.print(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

