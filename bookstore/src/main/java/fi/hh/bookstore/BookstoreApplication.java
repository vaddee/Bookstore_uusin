package fi.hh.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.BookRepository;
import fi.hh.bookstore.domain.Category;
import fi.hh.bookstore.domain.CategoryRepository;
import fi.hh.bookstore.domain.User;
import fi.hh.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	//private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); lisää katso vko 4

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {

			//luonti
			Category category1 = new Category("Fantasy");
			
			Category category2 = new Category("Horror");
			
			Category category3 = new Category("Comedy");
			
			Category category4 = new Category("Documentary");
			
			Category category5 = new Category("Science-fiction");
			
			Category category6 = new Category("Crime");
			
			//tallennus
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			categoryRepository.save(category5);
			categoryRepository.save(category6);


			//luonti valmiiks tietokantaan
			Book book1 = new Book("Dune", "Orson Scott Card", 2008, "0099009", 20.00, category5);
			Book book2 = new Book("Song of fire", "George RR Martin", 1929, "100201", 40.5, category1);
			Book book3 = new Book("Vares", "Reijo Maki", 2001, "2209114", 19.00, category6);
			Book book4 = new Book("Muumilaakson tarinoita", "Tove Jansson", 1954, "111100", 15.40, category3);
			Book book5 = new Book("Starwars", "George Lucas", 1980, "9513341", 22.2, category5);

			
			
			
			//tallennus
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);

			//kayttajat , salasanat kryptattu bcryptcalculator.com
			User user1 = new User("user", "$2a$10$OdwcL53HITMJIKA/MdWgquYxiw/kiEq3tbcKeUBkMUwi1XhQ.EOdq", "matti.mattinen@gmail.com", "USER");

			User user2 = new User("admin", "$2a$10$I38vHRKPPIyXav4iWXmNy.wKnYp7DXjJpxzBID8jYWNiTi5eEaO8O", "maija.maijanen@gmail.com", "ADMIN");

			userRepository.save(user1); 
			userRepository.save(user2);

			


		};
	}

}
