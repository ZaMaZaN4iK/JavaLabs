package com.by.Zaitsev.DAO;

import com.by.Zaitsev.HomeLibrary.Author;
import com.by.Zaitsev.HomeLibrary.Books;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {

    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws SQLException;

    /** Возвращает объект для управления персистентным состоянием объекта Books */
    public GenericDao<Books, Integer> getBooksDao(Connection connection);

    /** Возвращает объект для управления персистентным состоянием объекта Author */
    public  GenericDao<Author, Integer> getAuthorDAO(Connection connection);
}