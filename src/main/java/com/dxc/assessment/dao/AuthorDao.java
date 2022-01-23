package com.dxc.assessment.dao;

import java.sql.SQLException;
import java.util.List;

import com.dxc.assessment.modal.Author;

public interface AuthorDao  {

    Author create(Author author) throws SQLException;

    Author findById(Long id) throws SQLException;
    
    List<Author> findByGenre(String genre) throws SQLException;

    List<Author> findAll() throws SQLException;

    static int save(Author as) {
        return 0;
    }
}
