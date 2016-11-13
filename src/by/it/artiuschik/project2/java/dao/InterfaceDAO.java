package by.it.artiuschik.project2.java.dao;
import java.util.List;

interface InterfaceDAO<TYPE> {
    TYPE read(int id);
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);
    List<TYPE> getAll(String WhereAndOrder);
}