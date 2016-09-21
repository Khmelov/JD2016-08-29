package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public class CargoShip extends Ship {
    @Override
    public boolean atSee() {
        System.out.println("Грузовой корабль в море!");
        return super.atSee();
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость Танкера  =  800м3");
    }


    @Override
    public void changeCource() {
        super.changeCource();
    }

    @Override
    public void loadShip() {
        super.loadShip();
    }
}
