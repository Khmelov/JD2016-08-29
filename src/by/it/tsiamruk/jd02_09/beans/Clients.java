package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class Clients {
    @XmlElement(name = "Client")
    private ArrayList<Client> list = new ArrayList<Client>();
    public Clients(){
    }
    public void setList(ArrayList<Client> list) {
        this.list = list;
    }

    public ArrayList<Client> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Clients[" +
                "list=" + list +
                ']';
    }
}
