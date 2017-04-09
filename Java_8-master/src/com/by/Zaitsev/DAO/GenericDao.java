package com.by.Zaitsev.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {

    /**Возвращает объект соответствующий записи с первичным ключом key или null*/
    public T read(int key) throws SQLException;

    /**Возвращает список объектов соответствующих всем записям в базе данных*/
    public List<T> getAll() throws SQLException;
}
