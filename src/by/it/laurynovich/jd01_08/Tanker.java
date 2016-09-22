package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public class Tanker extends CargoShip {
    private boolean help = false;
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
        if (state == true){
            System.out.println("Tanker должен вернуться в порт");
        help = true;}
        else
            System.out.println("Tanker может продолжать движение");
    }

    @Override
    public void changeCource() {
        System.out.println("Корабль может изменить курс");
            }

    @Override
    public void loadShip() {
        System.out.println("Загрузить танкер бочками");
    }

    public void setHelp(boolean state, boolean canGo){
        if (state ==true && canGo == false){
            System.out.println("SOS");}
        else{
            System.out.println("Tanker должен вернуться в порт");

        }

    }

    public void setHelp() {
        if (help = true) {
            System.out.println("Help");
        }
    }



}
