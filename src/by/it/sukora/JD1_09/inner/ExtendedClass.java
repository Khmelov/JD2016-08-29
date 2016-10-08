package by.it.sukora.JD1_09.inner;

public class ExtendedClass extends ParentClass{
    protected class SubExtended extends SubClass {
        public SubExtended() {
            System.out.println("SubExtended создан");
        }
    }
}
