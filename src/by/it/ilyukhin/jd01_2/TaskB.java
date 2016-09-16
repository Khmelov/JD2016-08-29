package by.it.ilyukhin.jd01_2;

public class TaskB {
    //Принадлежность числа к интервалу [n;m]
    static int accessoryInterval(int n,int m,int k) {
        System.out.println("Введите значение k");
        if (k >= n && k <= m) {
            System.out.println("k принадлежит индервалу [n;m]");
        } else {
            System.out.println("k не принадлежит интервалу [n;m]");
        }

        return 0;
    }

    //Вывод массива
    static double massiveOut(int N,int k) {
        int K= (int) Math.sqrt(k);
        int col = 0;
        int[][] mas = new int[N][N];
        N = mas.length;
        for (int i = 1; i <= K; i++) {
            System.out.printf("%-6d", i);
            col++;
            if ((col % N) == 0) {
                System.out.println();
            }
        }

        return 0;
    }
    static double quadraticEquation(double a,double b,double c) {
        double x = 0,x1,x2,x3,D;
        double z=Math.pow(x,2)*a+b*x+c;
        z=0;
        D=Math.pow(b,2)-4*a*c;
        if (D>0){
            x1=((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
            x2 = ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
            System.out.println("Корень x1="+x1);
            System.out.println("Корень x2="+x2);

        }
        if (D==0) {
            x3=-(b/2*a);
            System.out.println("Корень x3="+x3);
        }
        if (D<0){
            System.out.println("Решения нет");
        }
        return 0;


    }
    static int Months(int n) {
        if (n >= 1 && n <= 12 && (n * 10) % 10 == 0) {
            switch (n) {
                case 1:
                    System.out.println("Январь");
                    break;
                case 2:
                    System.out.println("Февраль");
                    break;
                case 3:
                    System.out.println("Март");
                    break;
                case 4:
                    System.out.println("Апрель");
                    break;
                case 5:
                    System.out.println("Май");
                    break;
                case 6:
                    System.out.println("Июнь");
                    break;
                case 7:
                    System.out.println("Июль");
                    break;
                case 8:
                    System.out.println("Август");
                    break;
                case 9:
                    System.out.println("Сентябрь");
                    break;
                case 10:
                    System.out.println("Октябрь");
                    break;
                case 11:
                    System.out.println("Ноябрь");
                    break;
                case 12:
                    System.out.println("Декабрь");
                    break;

            }
        }
        else{
                System.out.println("Вы ввели неверное число");
            }
            return 0;
        }
    }



