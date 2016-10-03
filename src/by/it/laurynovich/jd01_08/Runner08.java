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
        ship.inNeedToRepair(false);
        tanker.inNeedToRepair(false);
        tanker.changeCource();
        tanker.loadShip();
        ship.loadShip();
        ship.changeCource();
        tanker.capacity();
        ship.capacity();
        tanker.inNeedToRepair(true);
        //ship.setHelp(state1 , false);
        tanker.loadShip();
        ship.loadShip();

        ((Tanker) tanker).setHelp();
//        tanker.setHelp(state, false);
//        tanker.setHelp(state1, true);
        tanker.loadShip();


    }


}
