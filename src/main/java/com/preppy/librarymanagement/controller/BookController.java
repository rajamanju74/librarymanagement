package com.preppy.librarymanagement.controller;

import com.preppy.librarymanagement.entities.Book;
import com.preppy.librarymanagement.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@Tag(name = "Books", description = "Access and Modify books in library")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    @Operation(summary = "See all the books")
    @ApiResponse(responseCode = "200", description = "Retrieved")
    private ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.findBooks(), HttpStatus.OK);
    }

    @PostMapping
    private Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(id);
    }

    @GetMapping("/author")
    private ResponseEntity<List<Book>> getByAuthor(@RequestParam("author") String author){
        return new ResponseEntity<>(bookService.getBookByAuthor(author), HttpStatus.OK);
    }
}
