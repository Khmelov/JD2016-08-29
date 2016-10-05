package by.it.artiuschik.jd_01_15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*joijoijo*/
class TaskB {
    /**
     * @param args input params
     */
    public static void main(String[] args) {
        String src = System.getProperty("user.dir");//get project path
        src = src + "/src/by/it/artiuschik/";//get folder
        String fn = src + "jd_01_15/TaskB.java";
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fn));
            String line;
            while ((line = reader.readLine()) != null)

            {
                sb.append(line);
                sb.append("\n");
            }
            //processing
            Pattern pattern = Pattern.compile("((\\/((\\*{2})|(\\*))[^\\/]+\\/)|((\\/{2})(.)+))");
            Matcher matcher = pattern.matcher(sb);
            int pos = 0;
            while (matcher.find(pos)) {
                sb.delete(matcher.start(), matcher.end());
                matcher.reset(sb);
                //pos = matcher.start();
            }
            System.out.println(sb);
        /*Print results
        to console*/
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Unable to close file");
                }
            }
        }


    }
}
