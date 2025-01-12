package com.alura.literalura.dto;

import com.alura.literalura.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public record BookDTO(
        String title,
        List<Person> authors,
        List<String> languages,
        Integer downloads
) {
    @Override
    public String toString() {
        return "\n ---- BOOK ---- \n" +
                "Title: " + title + "\n" +
                "Authors: " + authors.stream()
                .map(Person::getName)
                .collect(Collectors.joining("; ")) + "\n"+
                "Languages: " + String.join(", ",languages) + "\n"+
                "Downloads: " + downloads + "\n";
    }
}
