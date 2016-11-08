package by.it.artiuschik.jd_01_08;

    interface IEdition {
    void open(int page) throws IncorrectBookPageException;//открыть издание на странице

    void open() throws IncorrectBookPageException;//открыть издание по закладке

    void close();//закрыть издание

    void doBookmark(int page);//сделать закладку

    void removeBookmark();//удалить закладку

    void read();//читать издание

    int age();//возраст издания

    void showInfo();//вывод подробной информации об издании
}
