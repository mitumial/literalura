
# Literalura

A basic Java program that obtains Project Gutenberg ebook metadata from a JSON web API named Gutendex, and stores it into a PostgreSQL database for future use. Developed with educational intent


## Acknowledgements

- [Gutendex web API for ebook metadata](https://gutendex.com/)
- [Alura Cursos](https://app.aluracursos.com/)


## Lessons Learned

- Applied MVC Design Pattern
- Simplified Java entities into DOTs
- Used Hibernate to map Java entities into tables from a PostgreSQL Database
- Used derived queries and JPQL to access data from a database
- Used Jackson Databind to convert data from the database into Java classes and viceversa

## Features

- Access a CLI Menu that receives alphanumeric values corresponding to a dedicated action
  - (1) Add a new book to the database
  - (2) Show all books on the database
  - (3) Show all authors on the database
  - (4) Find the authors alive of a given a year	
  - (5) Find the books of given a language	
  - (6) Count the number of books of a given language
  - (0) Exit the program


## Run Locally

Clone the project

```bash
  git clone https://github.com/mitumial/literalura.git
```

Go to the project directory

```bash
  cd my-project
```

Install dependencies

```bash
  mvn install
```

Run program

```bash
  mvn spring-boot:run
```


## Tech Stack

**Server:** Java 17, SpringBoot, Maven, Jackson Databind, Gutendex API, PostgreSQL
