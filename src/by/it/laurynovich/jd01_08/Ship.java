package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public abstract class Ship implements IShip {
    @Override
    public boolean atSee() {
        return true;
    }

    @Override
    public void capacity() {

    }

    @Override
    public void inNeedToRepair(boolean state) {
        if (state == false) {
            System.out.println("Корабль не требует ремонта");
        } else {
            System.out.println("Корабль требует ремонта");

        }

    }

    @Override
    public void changeCource() {

    }

}
