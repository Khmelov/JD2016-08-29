package by.it.artiuschik.jd_01_08;

public class ReferenceBook extends Book {
    private String subject;//информацию по какому вопросу содержит справочник

    public ReferenceBook() {
        super();
        this.subject = "unknown";
    }

    public ReferenceBook(String name, int year, int pages, String subject, String... authors) {
        super(name, year, pages, authors);
        this.subject = subject;
    }

    @Override
    public void open(int page) throws IncorrectBookPageException{
        super.open(page);
        if(page<0)
        {
            throw new IncorrectBookPageException("Incorrect book page number");
        }
        System.out.println("Reference book " + getName() + " is opened on page " + page);
    }


    @Override
    public void close() {
        super.close();
        System.out.println("Reference book " + getName() + " is closed");

    }

    @Override
    public void read() {
        super.read();
        System.out.println("You are reading a reference book " + getName());

    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Вид книги: Reference book");
        System.out.println("Тема: " + this.subject);

    }

    public void doBookmark(int page) {
        super.doBookmark(page);
        System.out.println("You add a bookmark to your reference book " + getName() + " on page " + page);
    }

    @Override
    public void removeBookmark() {
        super.removeBookmark();
        System.out.println("Your reference book " + getName() + " hasn't got any bookmark now");
    }

    @Override
    public String toString() {
        return "Reference book "+getName();
    }
}
