package by.it.artiuschik.jd_02_10.TaskB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FromJSONToXML {
    static Students fromJSONToPOJO(String json) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Students students = gson.fromJson(json, Students.class);
        return students;
    }

    public static void fromPOJOToXML(Students students, String XMLPath) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller m = context.createMarshaller();
        Students st = new Students() {
            {
                ArrayList<Student.Test.question> questions = new ArrayList<>();
                questions.add(new Student.Test.question("easy", "Question about functions"));
                questions.add(new Student.Test.question("medium", "Question about polinoms"));
                questions.add(new Student.Test.question("easy", "Question about matrix"));
                Student.Test test = new Student.Test("Algebra", questions);
                Student.Result result = new Student.Result("Algebra", "9");
                Student s = new Student("123", "Ivanov", "Ivan", "2", test, result);
                this.add(s);
                // добавление второго студента
                result = new Student.Result("Geometry", "9");
                test = new Student.Test("Geometry", questions);
                s = new Student("122", "Petrov", "Petr", "1", test, result);
                this.add(s);
            }
        };
        m.marshal(st, new FileOutputStream(XMLPath));
    }
}

