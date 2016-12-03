package by.it.artiuschik.project_Testing_system.java.dao;
import java.util.List;

/**
 *
 * @param <TYPE>
 */
interface InterfaceDAO<TYPE> {
    TYPE read(int id);
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);
    List<TYPE> getAll(String WhereAndOrder);
}