package com.alura.literalura.service;

import com.alura.literalura.dto.BookDTO;
import com.alura.literalura.model.Book;
import com.alura.literalura.model.Person;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    @Autowired
    private PersonRepository personRepository;

    public List<BookDTO> findAllWithAuthors(){
        return repository.findAllWithAuthors().stream()
                .map(b->new BookDTO(b.getTitle(), b.getAuthors(), b.getLanguages(), b.getDownloads()))
                .collect(Collectors.toList());
    }

    public void saveBook(Book book){
        repository.save(book);

        for (Person author: book.getAuthors()) {
            author.setBook(book);
        }
    }
}
