package by.it.artiuschik.jd_01_08;

   class Encyclopedia extends by.it.artiuschik.jd_01_08.Book {
    private int tomes;//количество томов
    private int tomeBookMark=0;
    Encyclopedia(String name, int year, int pages, int tomes, String... authors) {
        super(name, year, pages, authors);
        this.tomes = tomes;
    }
    @Override
    public void open(int page) throws IncorrectBookPageException  {
        if(page<0)
        {
            throw new IncorrectBookPageException("Incorrect book page number");
        }
        super.open(page);
        System.out.println("Encyclopedia is opened on page " + page);
    }

    @Override
    public void close() {
        super.close();
        System.out.println("Encyclopedia " + getName() + " is closed");

    }

    @Override
    public void read() {
        super.read();
        System.out.println("You are reading an encyclopedia " + this.getName());
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Вид книги: Encyclopedia");
        System.out.println("Количество томов: " + this.tomes);

    }

    @Override
    public void doBookmark(int page) {
        super.doBookmark(page);
        System.out.println("You add a bookmark to your encyclopedia " + getName() + " on page " + page);
    }
    void doBookmark(int tome,int page) {
        super.doBookmark(page);
        tomeBookMark=tome;
        System.out.println("You add a bookmark to your encyclopedia " + getName() + " on tome " + tomeBookMark+" on page " + page);
    }

    @Override
    public void removeBookmark() {
        super.removeBookmark();
        tomeBookMark=0;
        System.out.println("Your encyclopedia " + getName() + " hasn't got any bookmark now");

    }

    @Override
    public String toString() {
        return "Encyclopedia "+getName();
    }
}
