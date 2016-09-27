package by.it.sukora.jd01_13.HomwWork.TaskC;


public class Tunker extends CargoShip {

    String name;


    public void setName(String name){
        this.name=name;
    }




    @Override
    public void length_(double a) {
        try {
            super.length_(a);
        }
        catch (Exception e)
        {
            System.out.println("Error"+e);
        }
    }

    @Override
    public void width(double a) {
        super.width(a);
    }

    @Override
    public String showInfo() {

        return super.showInfo();
    }

    @Override
    public String name() {
        String IName="Моё название:";
        System.out.println(IName+" "+name);
        return IName;
    }

    @Override
    public void age() {
        super.age();
    }

    @Override
    public boolean tunker() {
        return super.tunker();
    }

    @Override
    public boolean rout() {
        return super.rout();
    }
}
