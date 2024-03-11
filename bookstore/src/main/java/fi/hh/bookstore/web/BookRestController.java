package fi.hh.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.BookRepository;


@CrossOrigin
@Controller
public class BookRestController {
 @Autowired
    private BookRepository bookRepository;

    // REST to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest(){
        return (List<Book>) bookRepository.findAll();
    }

    // REST to get book by id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional <Book> getOneBookById(@PathVariable("id") Integer bookId){
        return bookRepository.findById(bookId);
    }

     @RequestMapping(value = "/books", method = RequestMethod.POST)
    public @ResponseBody Book addNewBook(@RequestBody Book newBook){

        return bookRepository.save(newBook);

    } 
    


}
