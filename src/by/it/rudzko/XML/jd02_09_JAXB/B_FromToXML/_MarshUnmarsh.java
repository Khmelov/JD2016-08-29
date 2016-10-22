package by.it.rudzko.XML.jd02_09_JAXB.B_FromToXML;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class _MarshUnmarsh {
    public static void main(String[] args) {
        try {
            JAXBContext cont = JAXBContext.newInstance(Periodicals.class);
            Journals journals = new Journals();
            journals.addJ(new Journal("Бярозка", "For Teenagers", "month", "http://zviazda.by/be/edition/byarozka", 74822, RuOrBlr.BLR));
            Papers papers = new Papers();
            papers.addP(new Paper("Переходный возраст", "For Teenagers", "week", "http://www.pvz.by/", 63192, RuOrBlr.RU));
            Marshaller m = cont.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            System.out.println("Created XML:\n\n");
            m.marshal(new Periodicals(journals, papers), System.out);
            Unmarshaller unm = cont.createUnmarshaller();
            FileReader fr = new FileReader("src/by/it/rudzko/XML/jd02_09_JAXB/B_FromToXML/xml.xml");
            System.out.println("\n\nFrom XML to console:\n\n");
            System.out.println(unm.unmarshal(fr));
        } catch (FileNotFoundException e) {
            System.out.println("File not found." + e.getMessage());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
