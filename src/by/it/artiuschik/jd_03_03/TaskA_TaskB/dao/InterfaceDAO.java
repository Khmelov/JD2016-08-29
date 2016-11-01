package by.it.artiuschik.jd_03_03.TaskA_TaskB.dao;
import java.util.List;
interface InterfaceDAO<TYPE> {
    TYPE read(int id);
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);
    List<TYPE> getAll(String WhereAndOrder);
}