package by.it.rudzko.XML.jd02_07_xml_dtd_xsd;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class My_Validator {
    public static void main(String[] args) {
        String xml="src/by/it/rudzko/XML/jd02_07_xml_dtd_xsd/periodicals+XSD.xml";
        SchemaFactory create=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsd=new File("src/by/it/rudzko/XML/jd02_07_xml_dtd_xsd/periodicals.xsd");
        try {
            Schema schema=create.newSchema(xsd);
            Validator v=schema.newValidator();
            Source file=new StreamSource(xml);
            v.validate(file);
            System.out.println(xml+" is valid.");
            } catch (SAXException e) {
            System.out.println("Validation is impossible.");
        } catch (IOException e) {
            System.out.println(xml+" is not valid.");
        }


    }
}
