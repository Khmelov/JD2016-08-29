package by.it.artiuschik.jd_01_02;
import java.util.Scanner;

public class Util {
    /**
     * @param mas входной массив
     * @return перевернутый массив
     */
    static int[] reverseMas(int[] mas)
    {
        int temp;
        for(int i=0;i<mas.length/2;i++)
        {
            temp=mas[i];
            mas[i]=mas[mas.length-1-i];
            mas[mas.length-1-i]=temp;

        }
        return mas ;
    }
    static int[] matrixMinMaxElement(int[][] matrix,int n,boolean flag)
    //Возвращает массив в котором два первых элемента-это координаты минимума(максимума),
    //а третий элемент-сам минимум(максимум)
    {
        int result=matrix[0][0];
        int xCoord=0;
        int yCoord=0;
        int[] res=new int[3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(flag==true) {
                    if (matrix[i][j] < result) {
                        result = matrix[i][j];
                        xCoord = i;
                        yCoord = j;
                    }
                }
                else
                {
                    if(matrix[i][j]>result){
                        result = matrix[i][j];
                        xCoord = i;
                        yCoord = j;
                    }
                }
            }
        }
        res[0]=xCoord;
        res[1]=yCoord;
        res[2]=result;
        return res;
    }

    static int[] moveZerosToEnd(int[] mas)
    {
        int count=0;
        for(int i=0;i<mas.length;i++)
        {
            if(mas[i]!=0)
            {
                mas[count]=mas[i];
                count++;
            }
        }
        for(int i=count+1;i<mas.length;i++)
        {
            mas[i]=0;
        }
        return mas;
    }
    static double srednArifm(int[] mas)
    {
        double sum=0;
        for(int i=0;i<mas.length;i++)
        {
            sum+=mas[i];
        }
        return sum/mas.length;
    }
    static public String readFromConsole(){
        String result;
        Scanner scanner=new Scanner(System.in);
        result=scanner.nextLine();
        return result;
        //return new Scanner(System.in).nexLine();
    }
    static public int[] getArrayInt(String line){
        String strArray[]=line.split(" ");
        int result[]=new int[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            result[i]=Integer.parseInt(strArray[i]);

        }
        return result;
    }
    static public void printArray(int[] mas){
        for(int value:mas){
            System.out.print(" "+value);
        }
    }
}
