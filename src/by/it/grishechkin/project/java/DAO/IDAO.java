package by.it.grishechkin.project.java.DAO;

import java.util.List;

/**
 * Created by Yury on 30.10.2016.
 */
public interface IDAO <T>{
    int create(T entity);
    List<T> read(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
}
