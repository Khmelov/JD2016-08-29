package by.it.vashukevich.jd02_07.classwork;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidXSD {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName="src/by/it/vashukevich/jd02_07/classwork/ad+xsd.xml";
        String shcemaName="src/by/it/vashukevich/jd02_07/classwork/ad.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(shcemaName);
        try{
            //создание схемы
            Schema schema=factory.newSchema(schemaLocation);

            Validator validator=schema.newValidator();

            Source source=new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName+" validate");

        } catch (SAXException e) {
           System.err.print("Валидация"+fileName+" не выполнена: "+e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName+" не выполнена: "+e.getMessage());
        }
    }
}
