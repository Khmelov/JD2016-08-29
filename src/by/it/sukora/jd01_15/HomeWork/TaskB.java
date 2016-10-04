package by.it.sukora.jd01_15.HomeWork;
/*
fdhdhsgf
hsghs
fghs
fgh
sfgh
sfg
hdsf
hsgf
hfsgt
h
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TaskB
public class TaskB {
    public static void main(String[] args) {

        String src = System.getProperty("user.dir");
         src=src+"\\src\\by\\it\\";
       // src = src + "\\src\\";
        String fn=src+"sukora\\jd01_15\\HomeWork\\TaskB.java";
       // String fn = src + "JD01\\jd01_15\\HomeWork\\TaskB.java";
        System.out.println(fn);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(fn)
                     )) {
            //int i;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.print(line + "\n");
                sb.append(line+"\n");

            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not read");
            e.printStackTrace();
        }
            //processing
        Pattern pattern = Pattern.compile("/\\*((.)|(\\n))+\\*/");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }
    // String fn="D:\\курсы JAVA\\занятия\\JD01.JD1_01\\src\\JD01.jd01_15\\HomeWork\\TaskB.java";

    // FileReader filereader = new FileReader(fn);

}
