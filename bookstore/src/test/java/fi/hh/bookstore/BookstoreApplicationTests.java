package fi.hh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.bookstore.web.BookController;
import fi.hh.bookstore.web.CategoryController;


@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
		private BookController bookController;

		@Autowired
		private CategoryController categoryController;

	@Test
	void bookControllerTest() {
		

		assertThat(bookController).isNotNull();

	}

	@Test
	void categoryControllerTest() {
		

		assertThat(categoryController).isNotNull();

	}



}
