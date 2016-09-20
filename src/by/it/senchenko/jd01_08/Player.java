package by.it.senchenko.jd01_08;


public abstract class Player implements IEquipment{

    private boolean status = false; //состояние плеера исправен/сломан
    private boolean on = false; //состояние плеера включен/выключен
    protected boolean play = false; //плеер играет
    private boolean pause = false; //плеер на паузе да/нет

    /**
     *equipmentStatus()- возвращает текущее состояние плеера(исправен или нет)
     * @return
     */
    @Override
    public boolean equipmentStatus() {
        return status;
    }

    /**
     * equipmentOn() - устанавливает флаги on и play на true
     */
    @Override
    public void equipmentOn() {
        on = true;
        play = true;
    }

    /**
     * equipmentWorks() - возвращает текущее состояние плеера(работает или нет)
     * @return
     */
    @Override
    public boolean equipmentWorks() {
        return on;
    }

    /**
     * equipmentResult() - возвращает текущее состояние игры плеера(играет или нет)
     * @return
     */
    @Override
    public boolean equipmentResult() {
        return play;
    }

    /**
     * equipmentOff() - выключает плеер
     */
    @Override
    public void equipmentOff() {
        on = false;
    }

    /**
     * equipmentBreak() - ломает плеер
     */
    @Override
    public void equipmentBreak() {
        status = false;
    }

    /**
     * equipmentFix() - чинит плеер
     */
    @Override
    public void equipmentFix() {
        status = true;
    }

    /**
     * pause() - меняет флаг, ставит плеер на паузу
     */
    public void pause(){
        play = !play;
    }

    /**
     * chooseFile - принимает на вход целое значение, выбирает файл
     * @param file
     */
    public abstract void chooseFile(int file);

    /**
     * volumeUp() - увеличивает громкость
     */
    public abstract void volumeUp();

    /**
     * volumeDown() - уменьшает громкость
     */
    public abstract void volumeDown();
    public boolean stateStatus(){return status;}
    public boolean stateOn(){return on;}
    public boolean statePlay(){return play;}
    public boolean statePause(){return pause;}
}
