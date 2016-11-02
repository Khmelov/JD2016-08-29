package by.it.vashukevich.jd02_08.jd02_08_home;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;


public class STAX {
    private static String tab="";
    private static String text="";
    public static void main(String[] args) {
        String  file="D:\\Java\\JD2016-08-29\\src\\by\\it\\vashukevich\\jd02_08\\jd02_08_home\\elective.xml";
        XMLInputFactory factory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.println(tab+"<"+reader.getLocalName()+">");
                        tab+="\t";
                        int attr=reader.getAttributeCount();
                        for (int i = 0; i <attr ; i++) {
                            System.out.print(" "+reader.getAttributeLocalName(i)+"\""+reader.getAttributeValue(i)+"\""+">");
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                        text=text.concat(reader.getText().trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if(!text.isEmpty())
                            System.out.println(tab+text);
                        tab=tab.substring(1);
                        System.out.println(tab+"</"+reader.getLocalName()+">");
                        text="";
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

