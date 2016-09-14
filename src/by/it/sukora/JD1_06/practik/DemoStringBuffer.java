package by.it.sukora.JD1_06.practik;

import java.io.IOException;

/**
 * Created by stasi on 09.09.2016.
 */
public class DemoStringBuffer {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —>" + sb.capacity());
        sb.append("Java");
        System.out.println("строка —> " + sb);
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —> " + sb.capacity());
        sb.append("Internationalization");
        System.out.println("строка —> " + sb);
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —> " + sb.capacity());
        System.out.println("реверс —> " + sb.reverse());

    }
}
