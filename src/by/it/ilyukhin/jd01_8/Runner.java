package by.it.ilyukhin.jd01_8;


public class Runner {
    public static void main(String[] args) {

        Model modelC65 = new Model();
        System.out.println(modelC65.showState());

        modelC65.answer();
        System.out.println(modelC65.showState());
        modelC65.missed();
        System.out.println(modelC65.showState());
        modelC65.reset();
        System.out.println(modelC65.showState());

    }
}