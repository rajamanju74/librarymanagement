package com.preppy.librarymanagement.service;

import com.preppy.librarymanagement.entities.Book;
import com.preppy.librarymanagement.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    Logger logger = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = findBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public List<Book> findBooks() {
        List<Book> list =  bookRepository.findAll();
        for(Book b : list){
            logger.info("Books returned: {}", b.toString());
        }

        return list;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> getBookByAuthor(String author){
        String validAuthor = validate(author);
        return bookRepository.getByAuthorName(validAuthor);
    }

    private String validate(String author) {
        if(!author.isBlank()){
            author = author.trim().replaceAll("[<>]", "");
        }
        logger.info("Sanitized Author: {}", author);
        return author;
    }
}
