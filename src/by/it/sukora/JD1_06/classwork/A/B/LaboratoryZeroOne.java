package by.it.sukora.JD1_06.classwork.A.B;

import java.util.Arrays;

/**
 * Created by stasi on 12.09.2016.
 */
public class LaboratoryZeroOne {

    private StringBuilder verib;
    private StringBuilder out = new StringBuilder(110);

    public LaboratoryZeroOne(StringBuilder str)
    {
        this.verib = str;
    }

    public void Processing()
    {
        if(this.verib.length()<1)
        {
            System.out.println("error");
        }
        else
        {
            String[] var = this.verib.toString().split("[.!?]");
            int in[][] = new int[var.length][2];
            int i = 0;
            Arrays.sort(var);
            for(String strin : var)
            {
                String[] tmp = strin.split("[ ,:;]");
                if(tmp[0].isEmpty())
                    in[i][0]= tmp.length-1;
                else
                    in[i][0]= tmp.length;
                in[i][1]= i;
                System.out.println(tmp.length);

                i++;
            }
            int[] t  ;
            for(int z=in.length-1;z>0;z--){
                for(i=0;i<z;i++){
                    if(in[i][0]>in[i+1][0]){
                        t=in[i];
                        in[i]=in[i+1];
                        in[i+1]=t;
                    }
                }
            }
            for(int z=in.length-1;z>-1;z-- )
            {
                this.out.append(var[in[z][1]]+".");
            }
            System.out.println(this.out.toString());
        }
    }

    public StringBuilder getWorktype()
    {
        return this.out;
    }

    public void setWorktype(StringBuilder str)
    {
        this.verib = str;
    }
}
