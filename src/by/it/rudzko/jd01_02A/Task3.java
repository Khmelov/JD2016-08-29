package by.it.rudzko.jd01_02A;

/**
 * Created by Kir on 05.09.2016.
 */
public class Task3 {
    static boolean diffChar (int value) {
        //boolean res = false;

            String entered = Integer.toString(value);
            int l=entered.length();

            if(l==1){
            return false;}

                char[] num = entered.toCharArray();
                for (int i = 0; i < num.length - 1; i++) {
                    for (int j = i + 1; j < num.length; j++) {
                        if (num[i] == num[j]) {
                            return false;
                    }
                }
            }

        return true;
    }

    public static void printNum (int[] n){
        for(int i=0; i<n.length; i++){
            if(Task3.diffChar(n[i])){
                System.out.println("\nThe first number from different digits only is "+n[i]+".");
                break;
            }
        }
    }

}
