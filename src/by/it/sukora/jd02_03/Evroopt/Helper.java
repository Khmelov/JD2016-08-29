package by.it.sukora.jd02_03.Evroopt;


public class Helper {
    protected static int rnd(int from, int to) {
        int i = from + (int) (Math.round(Math.random() * (to - from)));
        return i;
    }

    protected static int rnd(int max) {
        return rnd(0, max);
    }

    protected static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 100000;
            iniTime = System.nanoTime();

            return "Прошло " + Delta.toString() + " милисекунд.";
        }

    }
}
