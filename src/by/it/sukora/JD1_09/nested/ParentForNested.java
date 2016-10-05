package by.it.sukora.JD1_09.nested;

/**
 * Created by Alex on 18.02.2016.
 */
public class ParentForNested {
    private int id;

    // abstract, final, private, protected - допустимы
    public static class SubClassNested {
        private int boatId;

        public static void downAll() {
            System.out.println("Всем стоп");
        }

        public void goOne() {
            System.out.println("Один пошел");
        }
    }
}