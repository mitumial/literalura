package com.alura.literalura.repository;

import com.alura.literalura.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByDeathyearGreaterThanEqual(Integer deathyear);

    Optional<Person> findByName(String name);
}
