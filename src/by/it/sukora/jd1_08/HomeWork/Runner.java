package by.it.sukora.jd1_08.HomeWork;


public class Runner {
    public static void main(String[] args) {
    Tunker tank = new Tunker();
        System.out.println("-------------------------------------------");
        tank.setName("Нефтяной танкер");
        tank.name();
        tank.age();
        tank.info(true,true);
        tank.length_(37.6);
        tank.width(15.8);
        tank.showInfo();
        Tunker CargoShip = new Tunker();
        System.out.println("-------------------------------------------");
        CargoShip.setName("Грузовой корабль");
        CargoShip.name();
        CargoShip.age();
        CargoShip.info(false,false);
        CargoShip.length_(55.6);
        CargoShip.width(22.8);
        CargoShip.showInfo();
        System.out.println("-------------------------------------------");
        WarShip warship = new WarShip();
        warship.setName("Эсминец");
        warship.name();
        warship.age();
        warship.info(false,true);
        warship.length_(48.2);
        warship.width(15.6);
        warship.showInfo();
        System.out.println("-------------------------------------------");





    }



}
