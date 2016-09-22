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
        System.out.println("Вместимость грузового корабля  =  500м3");
    }


    @Override
    public void changeCource() {
        System.out.println("Корабль может изменить курс");
    }

    @Override
    public void loadShip() {
        System.out.println("Загрузить корабль контейнерами");
    }

    @Override
    public void setHelp() {

    }

    @Override
    public void setHelp(boolean state, boolean canGo) {

    }


}
