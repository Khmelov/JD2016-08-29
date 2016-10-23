package by.it.artiuschik.jd_02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StAX
{
    private static String tab="";
    public static void main(String[] args)
    {
        String src = System.getProperty("user.dir");
        String path = src + "/src/by/it/artiuschik/jd_02_07/TestingSystem+XSD.xml";
        try(InputStream input=new FileInputStream(path))
        {
            XMLInputFactory inputFactory=XMLInputFactory.newInstance();
            XMLStreamReader reader=inputFactory.createXMLStreamReader(input);
            String element="";
            while(reader.hasNext())
            {
                int type=reader.next();
                switch(type)
                {
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.print(tab+"<" + reader.getLocalName());
                        tab=tab+"\t";
                        int countAttr=reader.getAttributeCount();
                        for (int i = 0; i < countAttr; i++) {
                            System.out.print(" "+reader.getAttributeLocalName(i)+"=");
                            System.out.print("\""+reader.getAttributeValue(i)+"\"");
                        }
                        System.out.println(">");

                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        element=element.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if (!element.isEmpty())
                            System.out.println(tab+element);
                        tab=tab.substring(1);
                        element="";
                        System.out.println(tab+"</" + reader.getLocalName() + ">");
                        break;
                    }
                }

            }

        }
        catch(IOException e)
        {
            System.out.println("Failed or interrupted I/O operation!");
        } catch (XMLStreamException e) {
            System.out.println("Unavailable to create XML reader");
        }
    }
}