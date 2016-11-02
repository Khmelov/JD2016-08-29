package by.it.grishechkin.jd01_08;

/**
 * Created by Yury on 15.10.2016.
 */
public abstract class Pleer implements ITech {

    boolean playState = false;
    public abstract void fullScreen();

    @Override
    public void play() {
        this.playState = true;
        System.out.println(Pleer.class.getName() + " play");
    }

    @Override
    public void pause() {
        this.playState = false;
        System.out.println(Pleer.class.getName() + " pause");
    }

    @Override
    public void stop() {
        this.playState = false;
        System.out.println(Pleer.class.getName() + " stop");
    }

    @Override
    public void addVolume() {
        System.out.println(Pleer.class.getName() + " add volume");
    }

    @Override
    public void minusVolume() {
        System.out.println(Pleer.class.getName() + " minus volume");
    }

    public void reloop() {
        System.out.println(Pleer.class.getName() + " reloop");
    }
}
