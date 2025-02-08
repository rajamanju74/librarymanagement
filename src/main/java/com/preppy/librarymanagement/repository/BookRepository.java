package com.preppy.librarymanagement.repository;

import com.preppy.librarymanagement.entities.Book;
import com.preppy.librarymanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //Long refers to the data type of primary key of the table

    @Query("select b from Book b where b.author = :author")
    List<Book> getByAuthorName(@Param("author") String author);
        //param maps to column name


}
