package com.alura.literalura.repository;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.authors")
    List<Book> findAllWithAuthors();

}
