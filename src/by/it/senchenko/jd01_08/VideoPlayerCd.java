package by.it.senchenko.jd01_08;


public class VideoPlayerCd extends VideoPlayer {
    public void play(){
        if (this.statePlay()){
            System.out.println("Sd плеер играет");
        }else {
            System.out.println("Sd плеер не играет");
        }
    }

}
