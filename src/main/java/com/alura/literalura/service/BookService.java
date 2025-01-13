package com.alura.literalura.service;

import com.alura.literalura.dto.BookDTO;
import com.alura.literalura.model.Book;
import com.alura.literalura.model.Person;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<BookDTO> findBooksByLanguage(String language){
        return repository.findBooksByLanguage(language).stream()
                .map(b->new BookDTO(b.getTitle(), b.getAuthors(), b.getLanguages(), b.getDownloads()))
                .collect(Collectors.toList());
    }

    public boolean isBookExistent(String title){
        Optional<Book> existingBook = repository.findByTitle(title);
        return existingBook.isPresent();
    }

    @Transactional
    public void saveBook(Book book) {
        List<Person> updatedAuthors = new ArrayList<>();

        for (Person author : book.getAuthors()) {
            Optional<Person> existingAuthor = personRepository.findByName(author.getName());

            if (existingAuthor.isEmpty()){
                personRepository.save(author);
            }

            // Use existing author to avoid duplicates or use a new one
            updatedAuthors.add(existingAuthor.orElse(author));
        }

        book.setAuthors(updatedAuthors);
        repository.save(book);
    }


}
