package by.it.senchenko.jd03_03.dao;

import java.util.List;

interface InterfaceForDAO<TYPE> {
    TYPE read(int id);
    boolean create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);
    List<TYPE> getAll(String WhereAndOrder);
}
