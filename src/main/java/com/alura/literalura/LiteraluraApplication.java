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
//		System.out.println("Are you performing a search? Y/N");
//		Boolean choice = "y".equalsIgnoreCase(sc.nextLine());
		var json = client.getBookData(URL_BASE + "dickens");
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