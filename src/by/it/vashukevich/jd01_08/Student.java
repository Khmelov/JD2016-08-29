package by.it.vashukevich.jd01_08;

/**
 * Created by Admin on 17.09.16.
 */
public abstract class Student implements IEnrollee {
    //private boolean stateLearn=false;
   // private boolean stateExamination=true;
    private int mark;
    private int secondMark;

    public Student(int i,int j) {
        mark = i;
        secondMark=j;
    }

    @Override
    public String toString() {
        return "На сессии я получаю только "+mark+","+secondMark;
    }

    @Override
    public void extramural() {
        System.out.println("Я студент заочник");
    }

    @Override
    public void work() {
        System.out.println("Я работаю, чтобы учиться");
    }

    @Override
    public void learn() {
        System.out.println("В свободное время я учусь");
    }

    @Override
    public void examination() {
        System.out.println("На сессии сдаю экзамены");
    }
    /* @Override
    public boolean learn() {
        stateLearn=true;
        stateExamination=false;
        return stateLearn;
    }

    @Override
    public void examination() {
        stateExamination=!stateExamination;
       // return stateExamination;
    }

    @Override
    public boolean work() {
        boolean nowWork=false;
        stateExamination=false;
        stateLearn=false;
        return nowWork;
    }

    public abstract String showState();
    public boolean isStateLearn(){return stateLearn;};
    public boolean isStateExamination(){return stateExamination;}*/

}
