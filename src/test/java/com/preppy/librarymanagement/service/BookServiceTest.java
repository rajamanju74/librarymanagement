package com.preppy.librarymanagement.service;

import com.preppy.librarymanagement.entities.Book;
import com.preppy.librarymanagement.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository repository;

    @InjectMocks
    BookService service;

    @Test
    void testGetByAuthor(){
        String author = "Doe John";
        Book book = new Book();
        book.setId(1L);
        book.setAuthor(author);
        book.setQuantity(4);
        book.setTitle("Book title");
        book.setCategory("Fiction");
        List<Book> books = List.of(book);

        when(repository.getByAuthorName(author)).thenReturn(books);

        List<Book> result = service.getBookByAuthor(author);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(books, result);
        verify(repository, times(1)).getByAuthorName(author);
    }


}
