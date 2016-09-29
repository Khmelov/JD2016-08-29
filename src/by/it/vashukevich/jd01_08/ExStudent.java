package by.it.vashukevich.jd01_08;

/**
 * Created by Admin on 21.09.16.
 */
public class ExStudent extends ExtramuralStudent{
    private int fourthMark;
    private int fifthMark;

    public ExStudent(int i, int j, int thirdMark, int fourthMark, int fifthMark) {
        super(i, j, thirdMark);
        this.fourthMark = fourthMark;
        this.fifthMark = fifthMark;
    }

    @Override
    public String toString() {
        return super.toString()+",а иногда и "+fourthMark+", и "+fifthMark;
    }
}
