package by.it.vashukevich.jd01_08;

/**
 * Created by Admin on 17.09.16.
 */
public class Runner {
    public static void main(String[] args) {
    Student extramuralStudent=new ExtramuralStudent(7,8,9);
       Student exStudent=new ExStudent(7,8,9,4,5);

        extramuralStudent.extramural();
        extramuralStudent.work();
        extramuralStudent.learn();
        extramuralStudent.examination();

        System.out.println(extramuralStudent.toString());
        System.out.println(exStudent.toString());

      /* System.out.println( extramuralStudent.showState());
       extramuralStudent.learn();
       System.out.println(extramuralStudent.showState());
       extramuralStudent.examination();
       System.out.println(extramuralStudent.showState());*/




    }
}
