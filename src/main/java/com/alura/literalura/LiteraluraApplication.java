package com.alura.literalura;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookData;
import com.alura.literalura.service.BookClient;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.DataConversor;
import com.alura.literalura.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private BookService service;

	@Autowired
	private PersonService personService;

	private final Scanner sc = new Scanner(System.in);
	private final String URL_BASE = "https://gutendex.com/books/?search=";
	private final BookClient client = new BookClient();
	private final DataConversor conversor = new DataConversor();

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		openMenu();
	}

	public void openMenu(){
		var opt = -1;
		while (opt != 0){
			var menu = """
					1 - Add new book
					2 - Show all books on library
					3 - Show all authors on library
					4 - Find authors alive by year
					5 - Find books by language
					
					0 - Close
					""";
			System.out.println(menu);
			opt = sc.nextInt();
			sc.nextLine();

			switch (opt){
				case 1:
					addBook();
					break;
				case 2:
					showLibrary();
					break;
				case 3:
					showAuthors();
                    break;
				case 4:
					findAuthorsByYear();
					break;
                case 5:
                    findBooksByLanguage();
                    break;
				case 0:
					System.out.println("Goodbye...");
					break;
				default:
					System.out.println("Option invalid");
			}
		}
	}

    private void addBook() {
		System.out.println("Which book do you wish to add?");
		String search = sc.nextLine();
		var json = client.getBookData(URL_BASE + search.toLowerCase().replaceAll(" ", "%20"));
		BookData data = conversor.getBookData(json, BookData.class);
        if (data == null) {
            System.out.println("No book found. Try again.");
            return;
        }
		System.out.println("Is this your book? (Y/N)");
		System.out.println(data);
		boolean flag = "y".equalsIgnoreCase(sc.nextLine());
        if (service.isBookExistent(data.title())){
            System.out.println("Book already exists!");
            return;
        }
		if (flag){
			service.saveBook(new Book(data));
			System.out.println("Book successfully stored!");
			System.out.println(service.findAllWithAuthors());
		} else {
			System.out.println("Try again");
		}
	}

	private void showLibrary(){
		System.out.println(service.findAllWithAuthors());
	}

	private void showAuthors() {
		System.out.println(personService.findAll());
	}

	private void findAuthorsByYear() {
		System.out.println("What year do you wish to filter by?");
		Integer year = sc.nextInt();
		sc.nextLine();
		System.out.println(personService.findByDeathYear(year));
	}

    private void findBooksByLanguage() {
        System.out.println("What language do you wish to filter by?");
        System.out.println("""
                en - English
                es - Spanish
                de - German
                it - Italian
                """);
        String lang = sc.nextLine();
        System.out.println(service.findBooksByLanguage(lang));
    }

}
