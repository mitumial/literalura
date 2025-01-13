package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer birthyear;
    private Integer deathyear;
    @ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
    private List<Book> books;

    public Person() {
    }

    public Person(PersonData personData) {
        this.name = personData.name();
        this.birthyear = personData.birthyear();
        this.deathyear = personData.deathyear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }

    public Integer getDeathyear() {
        return deathyear;
    }

    public void setDeathyear(Integer deathyear) {
        this.deathyear = deathyear;
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(Book book) {
        if (this.books == null){
            this.books = new ArrayList<>();
        }
        if (!this.books.contains(book)){
            this.books.add(book);
        }
        if (!book.getAuthors().contains(this)) {
            book.getAuthors().add(this);
        }
    }
}
