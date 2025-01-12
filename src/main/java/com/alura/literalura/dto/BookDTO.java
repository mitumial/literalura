package com.alura.literalura.dto;

import com.alura.literalura.model.Person;

import java.util.List;

public record BookDTO(
        String title,
        List<Person> authors,
        List<String> languages,
        Integer downloads
) {
}
