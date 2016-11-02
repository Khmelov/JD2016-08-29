package by.it.artiuschik.jd_02_09.TaskB_Manual;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ToXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller m = context.createMarshaller();
            Students st = new Students() { // анонимный класс
                {
                    ArrayList<Student.Test.question> questions=new ArrayList();
                    questions.add(new Student.Test.question("easy","Question about functions"));
                    questions.add(new Student.Test.question("medium","Question about polinoms"));
                    questions.add(new Student.Test.question("easy","Question about matrix"));
                    Student.Result result = new Student.Result("Algebra","9");
                    Student.Test test=new Student.Test("Algebra",questions);
                    Student s = new Student("123","Ivanov","Ivan","2",test,result);
                    this.add(s);
                    // добавление второго студента
                    result = new Student.Result("Geometry","9");
                    test=new Student.Test("Geometry",questions);
                    s = new Student("122", "Petrov", "Petr","1",test,result);
                    this.add(s);
                }
            };
            m.marshal(st, new FileOutputStream("src/by/it/artiuschik/jd_02_09/TaskB_Manual/xml_01.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out); // копия на консоль
        } catch (FileNotFoundException e) {System.out.println("XML-файл не может быть создан: " + e);}
        catch (JAXBException e) {        System.out.println("JAXB-контекст ошибочен " + e);        }
    }
}