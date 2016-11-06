package by.it.rudzko._Project.java.DAO;

import java.util.List;

interface InterfaceDAO<T> {
    T read(int id);
    T create(T entity);
    T update(T entity);
    boolean delete(T entity);

    List<T> getAll(String condition);

}
