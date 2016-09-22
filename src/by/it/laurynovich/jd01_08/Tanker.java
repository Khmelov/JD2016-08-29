package by.it.laurynovich.jd01_08;

/**
 * Created by vseotdala on 9/20/2016.
 */
public class Tanker extends CargoShip {

    private boolean help = false;
    @Override
    public boolean atSee() {
        boolean flag = true;
        System.out.println("//T Танкер в море!");
        return flag;
    }

    @Override
    public void capacity() {
        System.out.println("//T Вместимость Танкера  =  800м3");

    }

    @Override
    public void inNeedToRepair(boolean state) {
        if ( state == true){
            System.out.println("//T Tanker должен вернуться в порт");
        help = true;}
        else
            System.out.println("//T Tanker может продолжать движение");
    }

    @Override
    public void changeCource() {
        System.out.println("//T Корабль может изменить курс");
            }

    @Override
    public void loadShip() {
        System.out.println("//T Загрузить танкер бочками");

    }

    public void setHelp(boolean state, boolean canGo){
        if (state ==true && canGo == false){
            System.out.println("//T SOS");}
        else{
            System.out.println("//T Tanker должен вернуться в порт");

        }

    }

    public void setHelp() {
        if (help == true) {
            System.out.println("//T Help");
        }
    }



}
