package com.preppy.librarymanagement.entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String category;
    private Integer quantity;
    @Column(name = "updated_at")
    private final LocalDateTime updatedAt = LocalDateTime.now();
    @Column(name = "created_at", updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Override
    public String toString(){
        return "{\nid: "+this.id+
                "\ntitle: "+this.title+
                "\nauthor: "+this.author+
                "\n}";
    }
}
