package by.it.grishechkin.jd03_03.DAO;

/**
 * Created by Yury on 30.10.2016.
 */
public interface IDAO <T>{
    int create(T entity);
    void read(int ID);
    void update(T entity);
    void delete(T entity);
    void getAll();

}
