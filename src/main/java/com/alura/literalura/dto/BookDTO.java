package com.alura.literalura.dto;

import com.alura.literalura.model.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public record BookDTO(
        String title,
        List<Person> authors,
        List<String> languages,
        Integer downloads
) {
}
