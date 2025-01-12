package com.alura.literalura.dto;

public record PersonDTO(
        String name,
        Integer birthyear,
        Integer deathyear
) {
    @Override
    public String toString() {
        return  "\n ---- AUTHOR ---- \n" +
                "Author: " + name + "\n" +
                "Date of birth: " + birthyear + "\n" +
                "Year of death: " + deathyear + "\n";
    }
}