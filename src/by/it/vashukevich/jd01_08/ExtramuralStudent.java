package by.it.vashukevich.jd01_08;

/**
 * Created by Admin on 17.09.16.
 */
public class ExtramuralStudent extends Student {
    private int thirdMark;
    /*@Override
    public String showState() {
        String whatIDo = "Я работаю, чтобы учиться";
        if(this.isStateLearn()) {
            whatIDo="В свободное время я учусь";
            if(this.isStateExamination()){
                whatIDo="На сессии сдаю экзамены";
            }
        }
        return whatIDo;
    }*/

    public ExtramuralStudent(int i, int j, int thirdMark) {
        super(i, j);
        this.thirdMark = thirdMark;
    }

    @Override
    public String toString() {
        return super.toString()+" и "+thirdMark;
    }
}
