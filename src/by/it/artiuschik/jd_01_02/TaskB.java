package by.it.artiuschik.jd_01_02;
public class TaskB
{
    static boolean inInterval(int number,int left,int right)
    {
        return (number >= left) && (number <= right);
    }
    static void printMatrix(double N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print((int)N*i+(j+1)+" ");
            }
            System.out.println();
        }
    }
    static String whatMounth(int number)
    {
        if((number>=1)&&(number<=12)) {
            String[] monthsNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            return monthsNames[number - 1];
        }
        return "Не существует месяца с номером "+number+"!";
    }
    static double[] kvadrUravn(double a,double b,double c)
    {
        double D=b*b-4*a*c;
        if(D<0)
        {
            return null;
        }
        else
        {
            if(D==0)
            {
                double[] res=new double[1];
                res[0]=-b/(2*a);
                return res;
            }
            else
            {
                double[] res=new double[2];
                res[0]=(-b+Math.sqrt(D))/(2*a);
                res[1]=(-b-Math.sqrt(D))/(2*a);
                return res;
            }
        }

    }
}
