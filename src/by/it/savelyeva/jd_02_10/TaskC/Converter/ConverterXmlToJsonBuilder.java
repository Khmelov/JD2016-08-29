package by.it.savelyeva.jd_02_10.TaskC.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
/**
 * Created by nato on 10/22/16.
 */
class ConverterXmlToJsonBuilder extends AbstractConverter {
    ConverterXmlToJsonBuilder(Class beanClass) {
        super(beanClass);
    }
    public ConverterXmlToJsonBuilder(Object bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String txtData) {
        try {
            StringReader stringReader = new StringReader(txtData);
            JAXBContext jc = JAXBContext.newInstance(getBeanClass());
            Unmarshaller u = jc.createUnmarshaller();
            bean = u.unmarshal(stringReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getConverterResult() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }

}
