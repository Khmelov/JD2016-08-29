package by.it.grishechkin.jd03_03.DAO;

import by.it.grishechkin.jd03_03.beans.User;

/**
 * Created by Yury on 30.10.2016.
 */
public interface IDAO <T>{
    int create(T entity);
    void read(int id);
    void update(T entity);
    void delete(T entity);
    void getAll();

}
