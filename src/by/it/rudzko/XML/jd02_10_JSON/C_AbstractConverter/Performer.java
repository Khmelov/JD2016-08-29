package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;


import java.io.File;
import java.io.IOException;

class Performer {


    static void doConvert(String conversion, Class beanClass, File from, File to){
        MyFactory f = new MyFactory();
        Converter c =f.createConverter(conversion,beanClass);
        try {
            c.convertFrom(from);
            c.writeTo(to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doConvert(String conversion, Class beanClass, String from, File to){
        MyFactory f = new MyFactory();
        Converter c =f.createConverter(conversion,beanClass);
        try {
            c.convertFrom(from);
            c.writeTo(to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String doConvert(String conversion, Class beanClass, File from){
        String res=null;
        MyFactory f = new MyFactory();
        Converter c =f.createConverter(conversion,beanClass);
       try {
           c.convertFrom(from);
           res = c.converted();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return res;
    }

    public static String doConvert(String conversion, Class beanClass, String from){
        String res;
        MyFactory f = new MyFactory();
        Converter c =f.createConverter(conversion,beanClass);
        c.convertFrom(from);
        res = c.converted();

        return res;
    }
}
