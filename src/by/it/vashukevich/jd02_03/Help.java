package by.it.vashukevich.jd02_03;

public class Help {
    protected static int fromTo(int from, int to) {
    int d = to - from;
    int msWait = from + (int) Math.round(Math.random() * d);
    return msWait;

}
    protected static int fromTo(int max){return fromTo(0,max);}

    protected static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
