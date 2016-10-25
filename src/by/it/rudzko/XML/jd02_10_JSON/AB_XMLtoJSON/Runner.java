package by.it.rudzko.XML.jd02_10_JSON.AB_XMLtoJSON;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        FileOutputStream printToXML=null;
        try {
            JAXBContext c=JAXBContext.newInstance(Periodicals.class);
            Unmarshaller unm = c.createUnmarshaller();
            FileReader fr = new FileReader("src/by/it/rudzko/XML/jd02_10_JSON/AB_XMLtoJSON/start.xml");
            Periodicals p=(Periodicals)unm.unmarshal(fr);
            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json=gson.toJson(p);            System.out.println(json);
            Periodicals fromJSON=gson.fromJson(json, Periodicals.class);
            Marshaller m = c.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            printToXML=new FileOutputStream("src/by/it/rudzko/XML/jd02_10_JSON/AB_XMLtoJSON/end.xml");
            m.marshal(fromJSON, printToXML);
        } catch (FileNotFoundException e) {
            System.out.println("File not found."+e.getMessage());;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (printToXML != null) {
                    printToXML.close();
                }
            } catch (IOException e) {
                System.out.println("Stream wasn't closed.");;
            }
        }
    }
}
