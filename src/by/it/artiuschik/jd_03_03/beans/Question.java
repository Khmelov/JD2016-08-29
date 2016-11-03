package by.it.artiuschik.jd_03_03.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Question", propOrder = {
        "ID",
        "Text",
        "Subject",
        "Balls"
})
public class Question {

    @XmlElement(name = "ID")
    protected int ID;
    @XmlElement(name = "Text", required = true)
    protected String Text;
    @XmlElement(name = "Subject", required = true)
    protected String Subject;
    @XmlElement(name = "Balls")
    protected int Balls;
    public Question() {

    }

    public Question(int ID, String text, String subject, int balls) {
        this.ID = ID;
        Text = text;
        Subject = subject;
        Balls = balls;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getBalls() {
        return Balls;
    }

    public void setBalls(int balls) {
        Balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (ID != question.ID) return false;
        if (Balls != question.Balls) return false;
        if (!Text.equals(question.Text)) return false;
        return Subject.equals(question.Subject);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Text.hashCode();
        result = 31 * result + Subject.hashCode();
        result = 31 * result + Balls;
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + ID +
                ", Text='" + Text + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Balls=" + Balls +
                '}' + "\n";
    }
}
