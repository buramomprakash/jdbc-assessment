package com.dxc.assessment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.assessment.modal.Author;


public class AuthorDaoImpl implements AuthorDao{


    private static final String INSERT_ONE_AUTHOR;

    private static final String SELECT_ALL_AUTHORS;

    private static final String FIND_BY_AUTHORS;
     
    private static final String FIND_BY_GENRE;

    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final String URL;





    static {
        INSERT_ONE_AUTHOR = "INSERT INTO authors ( first_name, last_name, genre, email) VALUES (?, ?, ?, ?)";
        SELECT_ALL_AUTHORS = "SELECT * FROM authors";
        FIND_BY_AUTHORS = "SELECT Author_Id, First_Name, last_Name, Genre, Email FROM authors where Author_ID = 2;";
        FIND_BY_GENRE = "SELECT Author_Id, First_Name, last_Name, Genre, Email FROM authors where Genre = comics;";

        USER_NAME = "root";
        PASSWORD = "password";

      
        URL = "jdbc:mysql://localhost:3306/dxc";
    }



    


    @Override
    public Author create(Author author) throws SQLException  {
        System.out.println("Saving author :" +author);
        Connection connection = DriverManager.getConnection(URL ,USER_NAME ,PASSWORD );
        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);

        ps.setString(1, author.getFirstName());
        ps.setString(2, author.getLastName());
        ps.setString(3, author.getGenre());
        ps.setString(4, author.getEmail());

        int rows = 0;
        rows = ps.executeUpdate();

        ps.close();
        connection.close();
        return   author;
    }

    @Override
    public Author findById(Long id) throws SQLException {
          List<Author> authors=null;

            Connection connection = DriverManager.getConnection(URL ,USER_NAME ,PASSWORD );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_BY_AUTHORS);
            authors = new ArrayList();
            while (rs.next()) {
                authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            statement.close();
            connection.close();
            return (Author) authors;
    }

    @Override
    public List<Author> findByGenre(String genre)  throws SQLException{
        
        List<Author> authors=null;

        Connection connection = DriverManager.getConnection(URL ,USER_NAME ,PASSWORD );
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FIND_BY_GENRE);
        authors = new ArrayList();
        while (rs.next()) {
            authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        rs.close();
        statement.close();
        connection.close();
        return authors;

    } 

        @Override
        public List<Author> findAll() throws SQLException {
           
            List<Author> authors=null;

            Connection connection = DriverManager.getConnection(URL ,USER_NAME ,PASSWORD );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHORS);
            authors = new ArrayList();
            while (rs.next()) {
                authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            statement.close();
            connection.close();
            return authors;
    
        }
}

