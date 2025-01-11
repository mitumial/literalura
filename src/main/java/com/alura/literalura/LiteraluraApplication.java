package com.alura.literalura;

import com.alura.literalura.model.BookData;
import com.alura.literalura.service.BookClient;
import com.alura.literalura.service.DataConversor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

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
					
					0 - Close
					""";
			System.out.println(menu);
			opt = sc.nextInt();
			sc.nextLine();

			switch (opt){
				case 1:
					addBook();
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
		System.out.println(data);
	}
}

//@SpringBootApplication
//public class ScreenmatchApplicationConsola implements CommandLineRunner {
//
//	@Autowired
//	private SerieRepository repository;
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplicationConsola.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(repository);
//		principal.openMenu();
//
//
//	}
