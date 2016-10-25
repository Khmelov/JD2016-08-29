package by.it.savelyeva.jd_02_10.TaskC.Converter;

import java.io.*;
/**
 * Created by nato on 10/22/16.
 */
abstract class AbstractConverter<T> {
    T bean;

    private Class beanClass;

    AbstractConverter(Class beanClass) {
        bean = null;
        this.beanClass=beanClass;
    }

    AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass=bean.getClass();
    }

    T getBean() {
        return bean;
    }

    Class getBeanClass() {
        return beanClass;
    }

    abstract public void buildConverter(String txtData);

    abstract public String getConverterResult();

    void buildConverter(File file){
        String txtData = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildConverter(txtData);
    }

    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(endFile))) {
            bufferedWriter.write(getConverterResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
