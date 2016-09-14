package by.it.rudzko.jd01_05;

/**
 * Created by Kir on 08.09.2016.
 */
public class calculation {
    public static double task1(double a, double x){
        System.out.println("Task 1:\n");
        double ln=Math.log(Math.abs((a-1.12*x)/4));
        double k=Math.sqrt(x*a*a*a);
        double cos=Math.cos(x*x+Math.PI/6);
        //double z=Math.cos(x*x+Math.PI/6)-Math.sqrt(x*a*a*a)-Math.log(Math.abs((a-1.12*x)/4));
        double z=cos-k-ln;
        return z;
    }
    public static double task2(double x[]){

        double a=x[0];
        double b=x[1];
        double tg=Math.tan(Math.pow(a+b, 2));
        double k=Math.pow((a+1.5), 1.00000/3);
        double sum=a*Math.pow(b,5)-b/Math.log(a*a);
        double res=tg-k+sum;
        return res;
    }
    public static double[][] task3(double x, double a1, double a2, double i){
        System.out.println("\nTask 3:\n");
        int l=(int)(Math.floor((a2-a1)/i+1));
        double res[][]=new double[l][2];
        double n=a1;
        for (int j=0; j<l; j++) {
                double f = Math.pow(Math.E, n * x) - 3.45 * n;
                res[j][0]=n;
                res[j][1]=f;
                n=n+i;
        }
        return res;
    }
    public static double task4(double x1, double x2, double d){
        System.out.println("\nTask 4:\n");
        double n=x1;
        double sum=0;
                for (int j=0; n<=x2; j++){
                        double res=0;

                      for (int a=6; a<12; a++){
                        res+=Math.pow(n+2, 1.3*a);

                      }
                      sum+=res;
                      n+=d;
        }

        return sum;
    }

    public static double [][] task5(double r, double p1, double p2, double i){
        System.out.println("\nTask 5:\n");
        int l=(int)(Math.floor((p2-p1)/i+1));
        double res[][]=new double[l][2];
        double n=p1;
        for (int j=0; j<l; j++) {

            if ((n-1)<0) {

                double z=Math.sin(n)*3.8;
                //последняя величина, имеющая числовое выражение:
                double s=Math.abs(z-1.4*r);
                //слишком большая степень:
                double y = Math.pow(4.67, s);
                res[j][0] = z;
                res[j][1] = y;

            }
            else if ((n-1)<3){

                double z=n*n*n-n;
                //последняя величина, имеющая числовое выражение:
                double s=Math.abs(z-1.4*r);
                //слишком большая степень:
                double y = Math.pow(4.67, s);
                res[j][0] = z;
                res[j][1] = y;
            }
            else {

                double z=Math.pow((2/(n+1)+Math.sin(Math.PI/6)),5);
                //последняя величина, имеющая числовое выражение:
                double s=(Math.abs(z-1.4*r));
                //слишком большая степень:
                double y = Math.pow(4.67, s);

                res[j][0] = z;
                res[j][1] = y;
            }
            n += i;


        }

    return res;
    }

    public static double[] task6 (double i){
        int l=(int)(Math.floor((9-5.33)/i+1));
        double res[]=new double[l];
        double x=5.33;
        for (int j=0; x<=9; j++){
            res[j]=Math.pow((x*x+4.5), 1.00000/3);
            x+=i;
        }

        return res;
    }

    public static double findGM(double[] a){

        int count=0;
        for (int i=0; i<a.length; i++){
            if (a[i]>3.5)
                count++;
        }


        double newRes[]= new double[count];
        int j=0;
        for (int i=0; i<a.length; i++){
            if (a[i]>3.5){
                newRes[j]=a[i];
                j++;
            }
        }
        System.out.println("\nThere're results more than 3.5:\n");
        InOut.arPrint(newRes, "z", 5);
        double comp=1;
        for (int i = 0; i <count ; i++) {
        comp*=newRes[i];
        }

        double gm=Math. pow(comp, 1.00000/count);
        return gm;
    }

}
