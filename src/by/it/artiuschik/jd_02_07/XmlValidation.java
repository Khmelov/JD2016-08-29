package by.it.artiuschik.jd_02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidation {
    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String src=System.getProperty("user.dir");
        String fileName =   src+"\\src\\by\\it\\artiuschik\\jd_02_07\\TestingSystem+XSD.xml";
        String schemaName = src+"\\src\\by\\it\\artiuschik\\jd_02_07\\TestingXSD.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Source source = new StreamSource(fileName);
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            validator.validate(source);
            System.out.println(fileName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация "+ fileName + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}
