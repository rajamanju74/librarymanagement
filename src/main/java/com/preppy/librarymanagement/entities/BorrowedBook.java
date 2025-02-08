package com.preppy.librarymanagement.entities;

import com.preppy.librarymanagement.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "user_id")
    private Long userId;*/

    //show the foreign key relationship
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;
    @Column(name = "created_at", updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private final LocalDateTime updatedAt = LocalDateTime.now();
}
