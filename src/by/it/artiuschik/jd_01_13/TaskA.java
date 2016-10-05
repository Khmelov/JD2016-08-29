package by.it.artiuschik.jd_01_13;

import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args){
        String line;
        double sum=0;
        while(!(line=Util.oneLine()).equals("END"))
        {
            try {
                double value = Double.valueOf(line.trim());
                if(value<0) {
                    throw new ArithmeticException("Отрицательное число");
                }
                sum=sum+Math.sqrt(value);
                System.out.println("Value=" + value + "Sum=" + sum);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Возникла ошибка преобразования числа "+line);
            }
            catch(ArithmeticException e){
                System.out.println("Возникла ошибка "+e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Возникла ошибка "+e.getLocalizedMessage());
            }
        }
    }
}
