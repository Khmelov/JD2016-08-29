package by.it.senchenko.jd01_08;


public class VideoPlayer extends Player {
    int movie = 1;
    int volume = 5; //звук изменяется от 1 до 10


    @Override
    public void pause() {
        super.pause();
        if(!play){
            System.out.println("Плеер на паузе");
        }
    }

    public void chooseFile(int movie) {
        this.movie = movie;
        System.out.println("Вы выбрали видео №"+this.movie);
    }

    @Override
    public void volumeUp() {
        if (volume < 10){
            volume +=1;
        }
        System.out.println("Звук увеличен до: "+this.volume);
    }

    @Override
    public void volumeDown() {
        if (volume > 0){
            volume -=1;
        }
        System.out.println("Звук уменьшен до: "+this.volume);
    }

    public void status(){
        if (this.stateStatus()){
            System.out.println("Плеер исправен");
        }else {
            System.out.println("Плеер сломан");
        }
    }

    public void onOf(){
        if (this.stateOn()){
            System.out.println("Плеер включен");
        }else {
            System.out.println("Плеер выключен");
        }
    }

    public void play(){
        if (this.statePlay()){
            System.out.println("Плеер играет");
        }else {
            System.out.println("Плеер не играет");
        }
    }

    public void version(int version){
        System.out.println("Версия плеера: "+version);
    }

    public void version(double version){
        System.out.println("Версия плеера: "+version);
    }
}