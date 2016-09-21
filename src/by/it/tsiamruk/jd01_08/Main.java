package by.it.tsiamruk.jd01_08;

/**
 * Created by waldemar on 20/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        ExternalStudent misha = new ExternalStudent();
        misha.setName("Михаил");
        misha.sayHello();
        misha.age();
        misha.russianTest();
        misha.englishTest();
        misha.graduation();
        misha.course();
        misha.working();
        System.out.println();
        Student alex = new ExternalStudent();
        alex.setName("Александр");
        alex.sayHello();
        alex.course();
        alex.graduation();



    }
}
