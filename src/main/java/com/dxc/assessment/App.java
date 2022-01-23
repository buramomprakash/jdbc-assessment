package com.dxc.assessment;

import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.dao.AuthorDaoImpl;
import com.dxc.assessment.modal.Author;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        findAllAuthors();
    }

    static void findAllAuthors(){
       
        AuthorDao authorDao= new AuthorDaoImpl();
        try {
            List<Author> authors = authorDao.findAll();
            if (authors.size() == 0) {
                System.out.println("No Authors found");
                return;
            }
            authors.forEach(as -> System.out.println(as));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    static void createAuthors() {
        Author  george=new Author("george","david","comics","georged@gmail.com");
        Author  trivikram=new Author("trivikram","srinivas","novels","tsrinu@gmail.com");
        Author  raja=new Author("raja","mouli","fictional","rrr@gmail.com");
        Author  boyapati=new Author("boyapati","srinu","adventerous","bs@gmail.com");
        
       
        List<Author> authors = List.of(george,trivikram,raja,boyapati);
        AuthorDao authorDao = new AuthorDaoImpl();

        authors.forEach(as -> {
            try {
                int rows = AuthorDao.save(as);
                System.out.println("Rows affected: " + rows);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
    }
}
