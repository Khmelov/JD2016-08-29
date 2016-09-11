package by.it.ilyukhin.jd01_5;


public class RunnerMath {
    public static void main(String[] args) {
        //Task_1 При заданных параметрах a=0.94 и x=10.093 выводит на консоль НЕ число
        double z = 0;
        System.out.println(Task_1.variantA(z));
        System.out.println(Task_1.variantB(z));

        //Task_2
        //первый вариант ввода
        System.out.println(Task_2.calculateA(10.093,0.94E-3));
        //второй вариант ввода
        System.out.println(Task_2.calculateB());
        //Task_3
        Task_3.printTable();
        //Task_4
        //System.out.println(Task_4.calculate());



    }
}
