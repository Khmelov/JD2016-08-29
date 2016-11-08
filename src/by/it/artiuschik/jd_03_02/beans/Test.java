package by.it.artiuschik.jd_03_02.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Test", propOrder = {
        "ID",
        "Name",
        "Subject",
        "Questions"
})
public class Test {
    @XmlElement(name = "ID")
    protected int ID;
    @XmlElement(name = "Name", required = true)
    protected String Name;
    @XmlElement(name = "Subject", required = true)
    protected String Subject;
    @XmlElement(name = "Questions")
    protected int Questions;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getQuestions() {
        return Questions;
    }

    public void setQuestions(int questions) {
        Questions = questions;
    }

    public Test(int ID, String name, String subject, int questions) {
        this.ID = ID;
        Name = name;
        Subject = subject;
        Questions = questions;
    }

    public Test() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        return ID == test.ID && Questions == test.Questions && Name.equals(test.Name) && Subject.equals(test.Subject);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Subject.hashCode();
        result = 31 * result + Questions;
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Questions=" + Questions +
                '}' + "\n";
    }
}
