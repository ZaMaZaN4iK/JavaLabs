package com.by.Zaitsev.MySQL_DAO;

import com.by.Zaitsev.DAO.DAO;
import com.by.Zaitsev.DAO.GenericDao;
import com.by.Zaitsev.HomeLibrary.Author;
import com.by.Zaitsev.HomeLibrary.Books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL_DAO implements DAO {

    private String user = "root";//Логин пользователя
    private String password = "";//Пароль пользователя
    private String url = "jdbc:mariadb://localhost/homelibrary?user=newuser&password=password"; //URL адрес
    private String driver = "org.mariadb.jdbc.Driver";//Имя драйвера

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url/*, user, password*/);
    }

    @Override
    public GenericDao<Books, Integer> getBooksDao(Connection connection) {
        return new MySQL_DAO_Books(connection);
    }

    @Override
    public GenericDao<Author, Integer> getAuthorDAO(Connection connection) {
        return new MySQL_DAO_Author(connection);
    }

    public MySQL_DAO() {
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
