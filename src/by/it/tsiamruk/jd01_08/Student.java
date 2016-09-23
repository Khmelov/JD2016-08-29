package by.it.tsiamruk.jd01_08;

/**
 * Created by waldemar on 20/09/2016.
 */
public abstract class Student implements IAbiturient {

    @Override
    public String sayHello() {
        String sayHello = "Я студент";
        return sayHello;
    }

    @Override
    public void age() {
        int age = 18;
        System.out.println("Мне уже " + age + "лет.");
    }

    void course() {
        System.out.println("Я учусь на последнем курсе");
    }

    @Override
    public void englishTest() {
        System.out.println("Оценка по английскому 100");
    }

    @Override
    public void graduation() {
        System.out.println("Оценка аттестата 100");
    }

    @Override
    public void mathTest() {
        System.out.println("Оценка по математике 100");
    }

    @Override
    public boolean working() {
        return false;
    }

    @Override
    public void russianTest() {
        System.out.println("Оценка по русскому 100");
    }

    public void setName(String name){

    }


}
