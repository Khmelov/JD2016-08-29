package by.it.vashukevich.jd01_13;

import java.util.ArrayList;
import java.util.List;

import static by.it.vashukevich.jd01_13.Util.oneLine;

/**
 * Created by Admin on 26.09.16.
 */
public class TaskA {
    public static void main(String[] args) {
        String line;
       double sum=0;
        while (!(line = Util.oneLine()).equals("end")) {
            try {
                double value = Double.valueOf(line.trim());
                if(value<0){
                    ArithmeticException e=new ArithmeticException("Отрицательное число");
                    throw e;
                }
                sum = sum + Math.sqrt(value);
                System.out.flush();
                System.out.println("Value=" + value + "Sum=" + sum);
            } catch (NumberFormatException e) {
                System.out.println("Возникла ошибка преобразования числа;" + line);
            }
            catch (ArithmeticException e){
                System.out.println("Возникла ошибка");
            }
        }
    }
}
