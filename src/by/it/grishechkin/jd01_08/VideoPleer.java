package by.it.grishechkin.jd01_08;

/**
 * Created by Yury on 15.10.2016.
 */

public class VideoPleer extends Pleer {

    boolean playState = false;

    @Override
    public void play() {
        this.playState = true;
        super.playState = true;
        System.out.println(VideoPleer.class.getName() + " play");
    }

    @Override
    public void pause() {
        this.playState = false;
        super.playState = false;
        System.out.println(VideoPleer.class.getName() + " pause");
    }

    @Override
    public void stop() {
        this.playState = false;
        super.playState = false;
        System.out.println(VideoPleer.class.getName() + " stop");
    }

    @Override
    public void addVolume() {
        System.out.println(VideoPleer.class.getName() + " add volume");
    }

    @Override
    public void minusVolume() {
        System.out.println(VideoPleer.class.getName() + " minus volume");
    }

    public void fullScreen() {
        System.out.println(VideoPleer.class.getName() + " full screen");
    }
}
