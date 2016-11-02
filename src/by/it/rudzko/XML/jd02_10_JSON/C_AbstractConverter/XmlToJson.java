package by.it.rudzko.XML.jd02_10_JSON.C_AbstractConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

class XmlToJson extends Converter {
    XmlToJson(Class beanClass) {
        super(beanClass);
    }
    public XmlToJson(Object bean) {
        super(bean);
    }

    @Override
    public void convertFrom(String str) {
        StringReader sReader = null;
        try {
            sReader=new StringReader(str);
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Unmarshaller u = jc.createUnmarshaller();
            bean = u.unmarshal(sReader);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        finally {
            if (sReader != null) {
                sReader.close();
            }
        }
    }

    @Override
    public String converted() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());

    }

}
