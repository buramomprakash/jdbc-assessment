package com.dxc.assessment.dao;



import java.util.List;
import com.dxc.assessment.modal.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class AuthorDaoImpl implements AuthorDao{

    private DataSource dataSource;

    private static final String INSERT_ONE_AUTHOR;

    private static final String SELECT_ALL_AUTHOR;


    static {
        INSERT_ONE_AUTHOR = "INSERT INTO authors (id, first_name, last_name, genre, email) VALUES (?, ?, ?)";
        SELECT_ALL_AUTHOR = "SELECT * FROM authors";
    }


    @Override
    public int save(Author author) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);
        ps.setString(1, author.getId());
        ps.setString(2, author.getFirst_Name());
        ps.setString(3, author.getLast_Name());
        ps.setString(3, author.getGenre());
        ps.setString(3, author.getEmail());
        int rows = 0;
        rows = ps.executeUpdate();

        ps.close();
        connection.close();
        return rows;
        return null;
    }

    @Override
    public Author findById(Long id) {
        return null;
    }

    @Override
    public List<Author> findByGenre(String genre) {
        return null;
    }

        @Override
        public List<Author> findAll() throws SQLException {
   
            Connection connection = dataSource.getConnection();
            List<Author> authors;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHOR);
            authors = new ArrayList();
            while (rs.next()) {
                authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            statement.close();
            connection.close();
            return authors;
    
        return null;
    }
}
