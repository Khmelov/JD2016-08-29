package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;

import java.io.*;

abstract class Converter<T> {
    T bean;
    private Class beanClass;

    Converter(Class beanClass) {
        bean = null;
        this.beanClass = beanClass;
    }

    Converter(T bean) {
        this.bean = bean;
        this.beanClass = bean.getClass();
    }

    T getBean() {
        return bean;
    }

    Class getBeanClass() {
        return beanClass;
    }

    abstract public void convertFrom(String str);

    void convertFrom(File from) throws IOException {
        String str = "";
        BufferedReader reader =null;
        try {
            reader=new BufferedReader(new FileReader(from));
            String read;
            while ((read = reader.readLine()) != null) {
                str += read;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        convertFrom(str);

    }

    abstract public String converted();

    void writeTo(File to) throws IOException {
        BufferedWriter writer =null;
        try {
            writer=new BufferedWriter(
                    new FileWriter(to));
            writer.write(
                    converted()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
