package by.it.artiuschik.jd_01_08;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Book implements IEdition {
    private String[] authors;
    private String name;
    private int year;
    private int pages;
    private boolean isOpened = false;//открыта ли книга для чтения
    private int bookMark = 0;//закладка (номер страницы)
    private boolean reading = false;//читают ли книгу сейчас

    public Book(String name, int year, int pages, String... authors) {
        this.name = name;
        this.year = year;
        this.pages = pages;
        this.authors = new String[authors.length];
        for (int i = 0; i < authors.length; i++) {
            this.authors[i] = authors[i];
        }
    }

    public Book() {
        this.authors = null;
        this.name = "unknown";
        this.year = 0;
        this.pages = 0;

    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String[] getAuthors() {

        return authors;
    }

    @Override
    public void open(int page) throws IncorrectBookPageException {
        isOpened = true;
    }

    @Override
    public void open() throws IncorrectBookPageException{
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
    public boolean isAuthor(String author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].equals(author)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showInfo() {
        System.out.println("Информация о книге");
        System.out.println("Название: " + this.name);
        System.out.println("Год издания: " + this.year);
        System.out.print("Авторы: ");
        for (int i = 0; i < authors.length; i++) {
            System.out.print(authors[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Book " + name;
    }
}
