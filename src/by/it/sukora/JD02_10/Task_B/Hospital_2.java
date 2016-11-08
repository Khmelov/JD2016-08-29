package by.it.sukora.JD02_10.Task_B;

/**
 * Created by Sukora Stas.
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Hospital_2 {

    @XmlElement(name = "Person")
    private ArrayList<Hospital> list = new ArrayList<>();

    public Hospital_2() {
        super();
    }

    public void setList(ArrayList<Hospital> list) {
        this.list = list;
    }

    public boolean add(Hospital person) {
        return list.add(person);
    }

    @Override
    public String toString() {
        return "Persons [list=\n" + list + "\n]";
    }
}
