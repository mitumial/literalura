package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<Person> authors;
    private List<String> languages;
    private Integer downloads;

    public Book() {
    }

    public Book(BookData bookData) {
        this.title = bookData.title();
        this.authors = bookData.authors().stream()
                .map(Person::new)
                .collect(Collectors.toList());
        this.languages = bookData.languages();
        this.downloads = bookData.downloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "Title: '" + title + "\n" +
                "Authors: " + authors.stream()
                .map(a->"\n" +a.getName()) + "\n"+
                "Languages: " + languages + "\n"+
                "Downloads: " + downloads;
    }
}
