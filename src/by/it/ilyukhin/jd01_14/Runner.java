package by.it.ilyukhin.jd01_14;


public class Runner {
    public static void main(String[] args){
        //TaskA
        String src = System.getProperty("user.dir");
        src = src + "/src/by/it/ilyukhin/";
        String fn = src + "jd01_14/numbers.dat";
        TaskA.writeToFile(fn);
        TaskA.readerOfFile(fn);
    }
}
