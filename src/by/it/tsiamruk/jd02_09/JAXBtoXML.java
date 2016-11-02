package by.it.tsiamruk.jd02_09;

import by.it.tsiamruk.jd02_09.beans.Client;
import by.it.tsiamruk.jd02_09.beans.Clients;
import by.it.tsiamruk.jd02_09.beans.PaymentSystem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;

/**
 * Created by waldemar on 29/10/2016.
 */
public class JAXBtoXML {
    public static void marshal(){
        try {
            JAXBContext context = JAXBContext.newInstance(PaymentSystem.class);
            Marshaller marshaller = context.createMarshaller();
            PaymentSystem paymentSystem = new PaymentSystem(){
                {
                    Clients clients = new Clients();

                    ArrayList<Client>list=new ArrayList<>();

                    Client client1 = new Client();
                    client1.setEmail("mail@mail.com");
                    client1.setLogin("logintest");
                    client1.setPassword("dummypass");
                    Client client2 = new Client();
                    client2.setEmail("mai2l@mail.com");
                    client2.setLogin("logintest2");
                    client2.setPassword("dummypass2");

                    list.add(client1);
                    list.add(client2);

                    clients.setList(list);
                }
            };
        } catch (JAXBException e) {
            System.err.println("Marshaller error" + e.getMessage());
        }
    }
}
