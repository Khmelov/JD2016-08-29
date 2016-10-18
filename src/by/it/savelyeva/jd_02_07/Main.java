package by.it.savelyeva.jd_02_07;

import org.xml.sax.SAXException;
import javax.xml.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName =   "src/by/it/savelyeva/jd_02_07/RentCarXSDTaskC.xml";
        String schemaName = "src/by/it/savelyeva/jd_02_07/RentCarTaskC.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " is valid.");
        } catch (SAXException e) {
            System.err.print("Validation for "+ fileName + " failed: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid:"
                    + e.getMessage());
        }
    }
}