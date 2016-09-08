package by.it.sukora.JD01_02;

/**
 * Created by stasi on 04.09.2016.
 */
public class TaskA {
//1
static String getMax(int array[])
{

    Integer max=Integer.MIN_VALUE;
    for(Integer i : array)
    {
        if (max<i)
        {
            max=i;

        }
    }
    return "Max= "+max.toString()+" Lennght= "+max.toString().length();
}

    static String getMin(int array[])
    {

        Integer min=Integer.MAX_VALUE;
        for(Integer i : array)
        {
            if (min<i)
            {
                min=i;

            }
        }
        return "Max= "+min.toString()+" Lennght= "+min.toString().length();
    }
//2
    static double mean(int array[])
    {
        double res=0;
        for (int i:array) res+=i;
        res=res/array.length;
        return  res;
    }
//3
    static boolean uniqueDigits(Integer value)
    {
        char ch[]=value.toString().toCharArray();
        for(int i=0;i<ch.length;i++)
            for(int j=i+1;j<ch.length;j++)
                if (ch[i]==ch[j])
                    return false;
        return  true;

    }


}
