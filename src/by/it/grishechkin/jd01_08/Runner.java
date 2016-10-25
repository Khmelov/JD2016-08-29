package by.it.grishechkin.jd01_08;

/**
 * Created by Yury on 19.10.2016.
 */
public class Runner {

    public static void main(String[] args) {
        VideoPleer obj = new VideoPleer();
        obj.play();
        obj.pause();
        obj.stop();
        obj.addVolume();
        obj.minusVolume();
    }
}
