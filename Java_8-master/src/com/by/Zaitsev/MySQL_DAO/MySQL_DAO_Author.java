package com.by.Zaitsev.MySQL_DAO;

import com.by.Zaitsev.DAO.GenericDao;
import com.by.Zaitsev.HomeLibrary.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQL_DAO_Author implements GenericDao<Author, Integer> {

    private final Connection connection;

    public List<Author> getAuthorN_Books(int key) throws SQLException{

        String sql = "SELECT Author.Name, Author.SecondName, Author.LastName, Author.ID, " +
                "COUNT(books.AuthorId) AS 'tests' " +
                "FROM homelibrary.Author, homelibrary.Books " +
                "WHERE  Author.ID = Books.AuthorId " +
                "GROUP BY author.Name HAVING tests < ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, key);
        ResultSet rs = stm.executeQuery();
        List<Author> list = new ArrayList<Author>();

        while (rs.next()) {
            Author g = new Author();
            g.ID =  rs.getInt("ID");
            g.LastName = rs.getString("LastName");
            g.SecondName = rs.getString("SecondName");
            g.Name = rs.getString("Name");
            list.add(g);
        }
        return list;
    }

    @Override
    public Author read(int key) throws SQLException {
        String sql = "SELECT * FROM homelibrary.Author WHERE id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, key);

        ResultSet rs = stm.executeQuery();
        rs.next();
        Author g = new Author();
        g.ID =  rs.getInt("ID");
        g.LastName = rs.getString("LastName");
        g.SecondName = rs.getString("SecondName");
        g.Name = rs.getString("Name");
        return g;
    }

    @Override
    public List<Author> getAll() throws SQLException {
        String sql = "SELECT * FROM homelibrary.Author;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Author> list = new ArrayList<Author>();
        while (rs.next()) {
            Author g = new Author();
            g.ID =  rs.getInt("ID");
            g.LastName = rs.getString("LastName");
            g.SecondName = rs.getString("SecondName");
            g.Name = rs.getString("Name");
            list.add(g);
        }
        return list;
    }

    public MySQL_DAO_Author(Connection connection) {
        this.connection = connection;
    }
}
