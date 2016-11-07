package by.it.rudzko._Project.java;

public class Runner {
    public static void main(String[] args) {
        DataBase db=new DataBase();
        db.buildDefaultStructure();
        //раскомментировать для того, чтобы заполнить таблицу (с пустой программа тоже будет работать корректно).
        //в соединении с базой данных для сдачи прописано имя it_academy, т.е. при запуске она будет перезаполнена
        db.reset();


    }
}
