package com.by.Zaitsev.Main;

import com.by.Zaitsev.DAO.GenericDao;
import com.by.Zaitsev.HomeLibrary.Author;
import com.by.Zaitsev.HomeLibrary.Books;
import com.by.Zaitsev.MySQL_DAO.MySQL_DAO;
import com.by.Zaitsev.MySQL_DAO.MySQL_DAO_Author;
import com.by.Zaitsev.MySQL_DAO.MySQL_DAO_Books;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MySQL_DAO dao = new MySQL_DAO();
        List<Books> books;
        List<Author> authors;
        try
        {
            Connection con = dao.getConnection();
            con.setAutoCommit(false);
            //con.setReadOnly(false);

            try
            {
                GenericDao<Books, Integer> booksDao = dao.getBooksDao(con);
                books = booksDao.getAll();
                System.out.println(books);
                System.out.println();

                GenericDao<Author, Integer> authorDao = dao.getAuthorDAO(con);
                authors = authorDao.getAll();
                System.out.println(authors);
                System.out.println();

                authors = ((MySQL_DAO_Author)(authorDao)).getAuthorN_Books(2);
                System.out.println(authors);
                System.out.println();

                books = ((MySQL_DAO_Books)(booksDao)).getBookLastYear();
                System.out.println(books);
                System.out.println();

                System.out.println("************************");
                ((MySQL_DAO_Books)(booksDao)).deleteBookYear(2016);

                books = booksDao.getAll();
                System.out.println(books);
                System.out.println();

                con.commit();
                System.out.println("Транзакция выполнена!");
            }
            catch (SQLException ex)
            {
                con.rollback();
                System.out.println(ex.getMessage());
                System.out.println("Транзакция не выполнена!");
            }
            finally
            {
                con.close();
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
