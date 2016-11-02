package by.it.rudzko.jd03_02;


import by.it.rudzko.jd03_02.POJO.MyDataBase;

public class Runner {

    public static void main(String[] args) {
        MyDataBase mdb=new MyDataBase();
        mdb.reset(mdb.buildDefaultStructure());
        System.out.println("\n-----------------\nCurrent users:");
        mdb.printUsers();
    }
}
