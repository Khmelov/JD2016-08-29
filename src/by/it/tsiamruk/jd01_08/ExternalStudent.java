package by.it.tsiamruk.jd01_08;

/**
 * Created by waldemar on 20/09/2016.
 */
public class ExternalStudent extends Student {

    private String name;

    @Override
    public void graduation() {
        super.graduation();
    }

    @Override
    public void mathTest() {
        super.mathTest();
    }

    @Override
    public void russianTest() {
        super.russianTest();
    }

    @Override
    public void englishTest() {
        super.englishTest();
    }

    @Override
    public void age() {
        int age = 20;
        System.out.println("Я уже больше чем " + age + " лет брожу по земле.");
    }

    @Override
    public boolean working() {
        boolean working = true;
        setFatigue(true);
        System.out.println("Я работаю? - " + working);
        System.out.println("Я устал:" + working);
        return working;
    }

    @Override
    public String sayHello() {
        String sayHello = " Я студент заочник";
        System.out.println("Меня зовут " + getName() + sayHello);
        return sayHello;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
