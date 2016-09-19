package by.it.senchenko.jd01_08;


public abstract class Player implements IEquipment{

    private boolean status = false; //состояние плеера исправен/сломан
    private boolean on = false; //состояние плеера включен/выключен
    protected boolean play = false; //плеер играет
    private boolean pause = false; //плеер на паузе да/нет

    /**
     *
     * @return
     */
    @Override
    public boolean equipmentStatus() {
        return status;
    }

    @Override
    public void equipmentOn() {
        on = true;
        play = true;
    }

    @Override
    public boolean equipmentWorks() {
        return on;
    }

    @Override
    public boolean equipmentResult() {
        return play;
    }

    @Override
    public void equipmentOff() {
        on = false;
    }

    @Override
    public void equipmentBreak() {
        status = false;
    }

    @Override
    public void equipmentFix() {
        status = true;
    }

    public void pause(){
        play = !play;  //переключает состояние паузы
    }

    public abstract void chooseFile(int file);    //реализовать метод выбрать файл
    public abstract void volumeUp();    //реализовать метод увеличить громкость
    public abstract void volumeDown();  //реализовать метод уменьшить громкость
    public boolean stateStatus(){return status;}
    public boolean stateOn(){return on;}
    public boolean statePlay(){return play;}
    public boolean statePause(){return pause;}
}
