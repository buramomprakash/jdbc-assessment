package com.dxc.assessment.dao;

import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao  {

    private static final String INSERT_ONE_AUTHOR;

    private static final String SELECT_ALL_AUTHOR;


    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final String URL;


    static {
        INSERT_ONE_AUTHOR = "INSERT INTO author (id,Genre ) VALUES (?, ?)";
        SELECT_ALL_AUTHOR = "SELECT * FROM author";

        USER_NAME = "root";
        PASSWORD = "password";

        // URL = "jdbc:mysql://server-name or server-ip-address:port/database-name";
        URL = "jdbc:mysql://localhost:3306/dxc";
    }

    public AuthorDao() {



    public List<Author> findAll() throws SQLException{
        List<Author> author = null;
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHOR);
        author = new ArrayList();
        while (rs.next()) {
            author.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3),);
        }
        rs.close();
        statement.close();
        connection.close();
        return author;
    }

    public int save(Author author) throws SQLException {
        System.out.println("Saving author: " + author);

        // Load the JDBC Driver
        // Automatically done for version 8 and above
        // DriverManager.registerDriver(Driver.class);
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // Get a connection to the database
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);

        ps.setString(1, book.getID());
        ps.setString(2, book.getGenre());
       
        int rows = 0;
        rows = ps.executeUpdate();

        ps.close();
        connection.close();

        return rows;
      }
    }

}
