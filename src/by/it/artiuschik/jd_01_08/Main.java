package by.it.artiuschik.jd_01_08;

public class Main {
    public static void main(String[] args) {
        Encyclopedia encyclopedia = new Encyclopedia("Все обо всем", 1995, 6300, 15, "А.Ликум", "Г.Шалаева");
        System.out.println(encyclopedia);
        encyclopedia.doBookmark(2, 45);
        encyclopedia.removeBookmark();
        System.out.println("Age="+encyclopedia.age());
        encyclopedia.showInfo();
        ReferenceBook referenceBook = new ReferenceBook("Справочник по грамматике английского языка", 2011, 96, "Английский язык", "Т.В. Митрошкина");
        System.out.println(referenceBook);
        referenceBook.doBookmark(15);
        referenceBook.removeBookmark();
        System.out.println("Age="+referenceBook.age());
        referenceBook.showInfo();
        //Динамический полиморфизм
        Book b1=new Encyclopedia("Все обо всем", 1995, 6300, 15, "А.Ликум", "Г.Шалаева");
        b1.showInfo();
        Book b2=new ReferenceBook("Справочник по грамматике английского языка", 2011, 96, "Английский язык", "Т.В. Митрошкина");
        b2.showInfo();
        System.gc();
    }

}
