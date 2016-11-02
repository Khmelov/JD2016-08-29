package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

class JsonToXml extends Converter {


    JsonToXml(Class beanClass) {
        super(beanClass);
    }

    public JsonToXml(Object bean) {
        super(bean);
    }

    @Override
    public void convertFrom(String str) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(str, getBeanClass());
    }

    @Override
    public String converted() {
        String res="";
        JAXBContext jc;
        StringWriter writer = null;
        try {
            jc = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            writer=new StringWriter();
            marshaller.marshal(getBean(), writer);
            res=writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res ;
    }


}
