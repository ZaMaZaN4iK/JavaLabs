package com.by.Zaitsev.MySQL_DAO;

import com.by.Zaitsev.DAO.GenericDao;
import com.by.Zaitsev.HomeLibrary.Books;

import java.sql.*;
import java.util.*;


public class MySQL_DAO_Books implements GenericDao<Books, Integer>{

    private final Connection connection;

    public List<Books> getBookLastYear() throws SQLException{

        String sql = "SELECT books.ID, books.AuthorId, books.Date, books.Izd, books.Name " +
                "FROM books WHERE YEAR(books.Date) >= YEAR(CURRENT_DATE()) - 1";

        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Books> list = new ArrayList<Books>();

        while (rs.next()) {
            Books g = new Books();
            g.ID =  rs.getInt("ID");
            g.AuthorID = rs.getInt("AuthorID");
            g.date = rs.getDate("Date");
            g.Izd = rs.getString("Izd");
            g.Name = rs.getString("Name");
            list.add(g);
        }
        return list;
    }

    public void deleteBookYear(int date) throws SQLException{

        String sql = "DELETE FROM books WHERE YEAR(books.Date) < ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, date);
        stm.executeUpdate();
    }

    @Override
    public Books read(int key) throws SQLException {
        String sql = "SELECT * FROM homelibrary.Books WHERE id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, key);

        ResultSet rs = stm.executeQuery();
        rs.next();
        Books g = new Books();
        g.ID =  rs.getInt("ID");
        g.AuthorID = rs.getInt("AuthorID");
        g.date = rs.getDate("Date");
        g.Izd = rs.getString("Izd");
        g.Name = rs.getString("Name");
        return g;
    }

    @Override
    public List<Books> getAll() throws SQLException {
        String sql = "SELECT * FROM homelibrary.Books;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Books> list = new ArrayList<Books>();
        while (rs.next()) {
            Books g = new Books();
            g.ID =  rs.getInt("ID");
            g.AuthorID = rs.getInt("AuthorID");
            g.date = rs.getDate("Date");
            g.Izd = rs.getString("Izd");
            g.Name = rs.getString("Name");
            list.add(g);
        }
        return list;
    }

    public MySQL_DAO_Books(Connection connection) {
        this.connection = connection;
    }
}
