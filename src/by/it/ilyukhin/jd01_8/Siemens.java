package by.it.ilyukhin.jd01_8;


public abstract class Siemens implements IMobile {
    private boolean answerCall=false;
    private boolean resetCall=false;


    @Override
    public boolean answer() {
        answerCall=true;
        resetCall=false;
        return answerCall;
    }

    @Override
    public boolean reset() {
        answerCall=false;
        resetCall=true;
        return resetCall;
    }

    @Override
    public void missed() {
        answerCall=!answerCall;
        System.out.println("Пропущенный вызов");

    }

    public abstract String showState();

    public boolean isAnswerCall() {return answerCall;}

    public boolean isResetCall() {return resetCall; }
}
