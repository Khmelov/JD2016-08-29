package by.it.artiuschik.jd_01_08;

import java.util.Calendar;
import java.util.GregorianCalendar;

abstract class Book implements IEdition {
    private String[] authors;
    private String name;
    private int year;
    private int pages;
    private boolean isOpened = false;//открыта ли книга для чтения
    private int bookMark = 0;//закладка (номер страницы)
    private boolean reading = false;//читают ли книгу сейчас

    Book(String name, int year, int pages, String... authors) {
        this.name = name;
        this.year = year;
        this.pages = pages;
        this.authors = new String[authors.length];
        System.arraycopy(authors, 0, this.authors, 0, authors.length);
    }

    public String getName() {
        return name;
    }

    @Override
    public void open(int page) throws IncorrectBookPageException {
        isOpened = true;
    }

    @Override
    public void open() throws IncorrectBookPageException {
        if (bookMark != 0) {
            this.open(bookMark);
        } else {
            this.open(0);
        }
    }

    @Override
    public void close() {
        isOpened = false;
        reading = false;
    }

    @Override
    public void doBookmark(int page) {
        bookMark = page;
    }

    @Override
    public void removeBookmark() {
        bookMark = 0;
    }

    @Override
    public void read() {
        reading = true;
    }

    @Override
    public int age() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR) - year;
    }

    @Override
    public void showInfo() {
        String string = "";
        if (!(isOpened && reading)) {
            string = "не";
        }
        System.out.println("Информация о книге");
        System.out.println("Название: " + this.name);
        System.out.println("Год издания: " + this.year);
        System.out.println("Количество страниц: " + this.pages);
        System.out.println("Книгу " + string + " читают");
        System.out.println("Книга " + string + " открыта");
        System.out.print("Авторы: ");
        for (String author : authors) {
            System.out.print(author + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Book " + name;
    }

    protected void finalize() throws Throwable {
        try {
            System.out.println("объект " + this + " будет удален");
        } finally {
            super.finalize();
        }
    }
}
