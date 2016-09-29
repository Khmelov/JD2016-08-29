package by.it.rudzko.jd01_13;

public class TaskA {

    public static void FindSQRT () {
        System.out.println("Найдем сумму корнейслучайных чисел. Введите первое число.");
        String line;
        double sum = 0;

        while (!(line=Util.oneLine()).equals("END")) {
            try {
                double value = Double.valueOf(line.trim());

                if (value<0){
                    ArithmeticException e=new ArithmeticException("Отрицательное число");
                    throw e;
                }

                sum+=Math.sqrt(value);
                System.out.flush();
                System.out.println("Value="+value+" Sum="+sum);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа "+line);
            }
            catch (ArithmeticException e){
                System.out.println("Возникла ошибка: "+e);
                }
                System.out.println("Введите следующее число. Для завершения программы введите 'END'.");
        }


    }
}
