package by.it.rudzko.jd02_04;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    private String str;

    public Finder(String s){
        setStr(s);
    }

    private void setStr(String s){
        this.str=s;
    }

    protected void find0x (){
        StringBuilder sb=new StringBuilder(str);
        Pattern p=Pattern.compile("0x[0-9A-Fa-f]*\\s");
        Matcher m=p.matcher(sb);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
