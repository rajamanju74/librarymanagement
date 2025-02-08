package com.preppy.librarymanagement.repository;

import com.preppy.librarymanagement.entities.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
