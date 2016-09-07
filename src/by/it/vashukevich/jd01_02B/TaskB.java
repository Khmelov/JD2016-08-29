package by.it.vashukevich.jd01_02B;

/**
 * Created by Admin on 06.09.16.
 */
public class TaskB {
       public static void intervalNum() {
        double k = 13.5;
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8};
        if (k >= m[0] && k <= m[7]) {
            System.out.print("k принадлежит интервалу");
        } else
            System.out.print("k не принадлежит интервалу");
    }

    public static void matrix() {
        double n=4;
        double k=Math.pow(n,2);
        for (int i = 1; i <= k; i++) {
            System.out.print(i + "\t");
            if(i % n == 0)
                System.out.println();
        }
    }
    public static void getNumMonth(){
        String month=null;
        //int[]mas={1,2,3,4,5,6,7,8,9,10,11,12};
        int num=8;
        if(num>=1||num<=12){
            switch(num){
                case 1: System.out.println("Январь");break;
                case 2: System.out.println("Февраль"); break;
                case 3: System.out.println("Март"); break;
                case 4: System.out.println("Апрель"); break;
                case 5: System.out.println("Май"); break;
                case 6: System.out.println("Июнь"); break;
                case 7: System.out.println("Июль"); break;
                case 8: System.out.println("Август"); break;
                case 9: System.out.println("Сентябрь"); break;
                case 10: System.out.println("Октябрь"); break;
                case 11: System.out.println("Ноябрь"); break;
                case 12: System.out.println("Декабрь"); break;
            }

    } else
            System.out.println("Введенному числу " + num + " не соответствует\n" +
            "ни один месяц. ");
    }
    public static void getSquarRoot(){

    }
}

