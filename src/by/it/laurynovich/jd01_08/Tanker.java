package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public class Tanker extends CargoShip {
    @Override
    public boolean atSee() {
        boolean flag = true;
        System.out.println("Танкер в море!");
        return flag;
    }

    @Override
    public void capacity() {
        System.out.println("Вместимость Танкера  =  800м3");

    }

    @Override
    public void inNeedToRepair(boolean state) {
        if (state == true)
            System.out.println("Tanker должен вернуться в порт");
        else
            System.out.println("Tanker может продолжать движение");
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
