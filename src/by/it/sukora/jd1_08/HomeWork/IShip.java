package by.it.sukora.jd1_08.HomeWork;


public interface IShip {


    void length_(double a); //длинна коробля
    void width(double a);//ширина
    String showInfo();  //информация о каробле

    String name(); //название

    void age();   //возвраст

    boolean tunker(); //танкер ли
    boolean rout(); //на маршруте ли


}
