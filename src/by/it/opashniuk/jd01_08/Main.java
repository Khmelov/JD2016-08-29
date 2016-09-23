package by.it.opashniuk.jd01_08;

public class Main {
    public static void main(String[] args) {
        Suit sportSuit = new Suit();
        System.out.println("Характеристики костюма:");
        sportSuit.color();
        sportSuit.composition();
        sportSuit.density();
        sportSuit.width();
        sportSuit.size();
        sportSuit.appoimtmet();
        sportSuit.forWhom();

        System.out.println();

        Suit2 sportWomanSuit = new Suit2();
        System.out.println("Характеристики костюма:");
        sportWomanSuit.color();
        sportWomanSuit.composition();
        sportWomanSuit.density();
        sportWomanSuit.width();
        sportWomanSuit.size();
        sportWomanSuit.appoimtmet();
        sportWomanSuit.forWhom();

    }

}
