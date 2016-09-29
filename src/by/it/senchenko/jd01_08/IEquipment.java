package by.it.senchenko.jd01_08;

/**@autor Denis Senchenko
 *Здесь описываются методы интерфейса IEquipment


 */

public interface IEquipment {
    //equipmentStatus - проверяет исправна ли техника

    public boolean equipmentStatus();     //реализовать

    //equipmentOn - приводит в работу технику
    public void equipmentOn();       //реализовать

    //equipmentWorks - проверяет работает ли техника в данный момент времени
    public boolean equipmentWorks();    //реализовать

    //equipmentResult - проверят результат работы техники
    public boolean equipmentResult();   //реализовать

    //equipmentOff - выключает технику
    public void equipmentOff();         //реализовать

    //equipmentBreak - ломает технику
    public void equipmentBreak();       //реализовать

    //equipmentFix - чинит технику
    public void equipmentFix();         //реализовать

}
