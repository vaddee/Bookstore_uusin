package fi.hh.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.BookRepository;
import fi.hh.bookstore.domain.CategoryRepository;


@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexPage() {
        return "index"; //index.html
    }
    

    
    @RequestMapping(value = "/booklist", method=RequestMethod.GET)
    public String getBooks(Model model) {

       
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // booklist.html
    }
    
    
    @RequestMapping(value ="/addbook", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {

        
        model.addAttribute("book", new Book()); 
        
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    @RequestMapping(value= "/savebook", method = RequestMethod.POST)
    public String saveBook(Book newBook, Model model) {

        // tallennus
        bookRepository.save(newBook);
        
        return "redirect:/booklist"; 
    }


    @RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')") //suojaa deleten vain adminille, case sensitive 
    public String deleteBook(@PathVariable("bookId") Integer bookId, Model model) {
        

        bookRepository.deleteById(bookId);

        return "redirect:/booklist";
    }

    @RequestMapping(value = "/editbook/{bookId}", method = RequestMethod.GET)
    public String editBookGet(@PathVariable("bookId") Integer bookId, Model model) {

        Optional<Book> bookToEdit = bookRepository.findById(bookId);


        // muokkaa kirjaa
        model.addAttribute("book", bookToEdit);

        return "editbook"; // editbook.html
    }


    @RequestMapping(value= "/editbook", method = RequestMethod.POST)
    public String editBookPost(Book editBook, Model model) {

      
        bookRepository.save(editBook);

       
        return "redirect:/booklist"; 
    }
}
