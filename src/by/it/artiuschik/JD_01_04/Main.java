package by.it.artiuschik.JD_01_04;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Матрица системы: ");
        double a[][]={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2}
        };
        InOut.printArr(a);
        System.out.println("Столбец свободных членов: ");
        double y[]={20,11,40,37};
        InOut.printArr(y,"Y",1);
        double x[]=Helper.findRoot(a,y);
        System.out.println("Корни уравнения: ");
        InOut.printArr(x,"X",1);
        System.out.println("Проверка: ");
        InOut.printArr(Helper.arrayMulVector(a,x),"Y",1);
        System.out.println("Определитель матрицы: ");
        System.out.println(Helper.det(a));
        System.out.println("Обратная матрица: ");
        InOut.printArr(Helper.inverseMatrix(a));
        System.out.println("Проверка: ");
        InOut.printArr(Helper.arrayMulVector(a,Helper.inverseMatrix(a)));

    }
}
