package fi.hh.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.BookRepository;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest

public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void FindByAuthorShouldReturnBook (){ // testataan BookRepository findbyauthor toimintaa
        List<Book> books = repository.findByAuthor("Reijo Maki");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Vares");
    }

    @Test
    public void createNewBook(){ //testataan save()toimivuutta
        Book book = new Book("Kokki", "Sikke", 2010,"90808", 19.3, null);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook(){ //testataan delete toimivuutta
        Book book = new Book("Kokki", "Sikke", 2010,"90808", 19.3, null);
        repository.save(book);
        repository.delete(book);
        assertThat(repository.findById(book.getId()).isEmpty());
    }
}
