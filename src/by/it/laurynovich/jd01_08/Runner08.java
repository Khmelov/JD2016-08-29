package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public class Runner08 {
    public static void main(String[] args) {
        Ship ship = new CargoShip();
        Ship tanker = new Tanker();

        //System.out.println(ship.atSee());
        //System.out.println(tanker.atSee());
        boolean state = ship.atSee();
        boolean state1 = tanker.atSee();
        System.out.println(state);
        System.out.println(state1);
        ship.inNeedToRepair(false);
        tanker.inNeedToRepair(false);
        tanker.changeCource();
        tanker.loadShip();
        ship.loadShip();
        ship.changeCource();
        tanker.capacity();
        ((CargoShip)ship).capacity();
        tanker.inNeedToRepair(true);
        ((CargoShip)ship).setHelp();
        tanker.loadShip();
        ship.loadShip();

        ((Tanker) tanker).setHelp();
        ((Tanker) tanker).setHelp(state, false);
        ((Tanker) tanker).setHelp(state1, true);
        tanker.loadShip();


    }


}
