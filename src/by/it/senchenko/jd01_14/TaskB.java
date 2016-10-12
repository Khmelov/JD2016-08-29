package by.it.senchenko.jd01_14;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws FileNotFoundException {
        int countPunct=0;
        int countWords=0;
        String fileName = "D:\\JD2016-08-29\\src\\by\\it\\senchenko\\jd01_14\\text";
        Scanner scan1 = new Scanner(new File(fileName));
        scan1.useDelimiter("[^.,!?\"()-;:]+");
        while (scan1.hasNext()){
            scan1.next();
            countPunct++;
        }
        scan1.close();
        Scanner scan2 = new Scanner(new File(fileName));
        scan2.useDelimiter("\\b[а-яА-ЯёЁa-zA-Z]+\\b");
        while (scan2.hasNext()){
            scan2.next();
            countWords++;
        }
        scan1.close();
        System.out.println("Количество знаков препинания: "+countPunct);
        System.out.println("Количество слов: "+countWords);
    }
}
