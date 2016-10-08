package by.it.rudzko.jd02_01;

/**
 * @author Olga Rudzko
 */
public class Helper {

    protected static int random(int a, int b){
        return (int)(Math.random()*(b-a)+1+a);
    }

    protected static int random(int a){
        return (int)(Math.random()*a+1);
    }

    protected static void performing(int duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
