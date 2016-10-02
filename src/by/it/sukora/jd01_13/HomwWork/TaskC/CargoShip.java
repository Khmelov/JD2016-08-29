package by.it.sukora.jd01_13.HomwWork.TaskC;


public abstract class CargoShip implements IShip {

    boolean test,rout;
    double len, wid;



    @Override
    public void length_(double a) {
        this.len=a;
    }

    @Override
    public void width(double a){
        this.wid=a;
    }

    @Override
    public String showInfo() {
        System.out.println("Длинна моего корпуса составляет "+len);
        System.out.println("Ширина моего корпуса составляет "+wid);

        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void age() {
    int age = 46;
        System.out.println("я нахожусь на плаву: "+age+" лет");
    }

    public void info(boolean test,boolean rout)
    {
        this.test=test;
        this.rout=rout;
        tunker();
    }
    
    @Override
    public boolean tunker() {

        if(test==true)
            System.out.println("Данный корабль является танкер? "+test);
        else
            System.out.println("Данный корабль является танкер? "+test);

        if(rout==true)
            System.out.println("Корабль на маршруте?? "+rout);
        else
            System.out.println("Корабль на маршруте?? "+rout);
        return test;

    }

    @Override
    public boolean rout() {
        return true;
    }

}
