package by.it.tsydzik.jd01_14;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Eugene Tsydzik
 * @since 12.10.16.
 */
public class TaskB {
    public static void taskB() {
        String src = System.getProperty("user.dir") + "/src/by/it/tsydzik/";
        File secondFile = new File(src + "jd01_14/Text.txt");
        DataOutputStream dos = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(secondFile);
            int wordsCount = 0;
            int punctuationMarksCount = 0;
            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                if ((char) ch == ' ') {
                    wordsCount++;
                }
                if ((char) ch == ';'
                        || (char) ch == ':'
                        || (char) ch == '.'
                        || (char) ch == ','
                        || (char) ch == '!'
                        || (char) ch == '?'
                        || (char) ch == '-')
                    punctuationMarksCount++;
            }
            System.out.println("Count punctuation Marks in file: " + punctuationMarksCount);
            System.out.println("Count of words in file: " + (wordsCount + 1));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
