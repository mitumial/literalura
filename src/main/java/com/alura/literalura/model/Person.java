package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer birthyear;
    private Integer deathyear;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return  "Author: '" + name + "\n" +
                "Date of birth: " + birthyear + "\n" +
                "Year of death: " + deathyear;
    }
}
