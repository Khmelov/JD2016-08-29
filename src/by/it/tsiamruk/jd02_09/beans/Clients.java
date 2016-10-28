package by.it.tsiamruk.jd02_09.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by waldemar on 28/10/2016.
 */
@XmlRootElement
public class Clients implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        return list.equals(clients.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
