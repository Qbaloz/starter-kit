package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }
    
    @RequestMapping(value = "/addbookbyparams", method = RequestMethod.POST)
    public BookTo saveBookParam(@RequestParam("id") Long id, @RequestParam("title") String title, @RequestParam("authors") String author) {
    	BookTo book = new BookTo();
    	book.setId(id);
    	book.setTitle(title);
    	book.setAuthors(author);
        return bookService.saveBook(book);
    }
    
    @RequestMapping(value = "/editbook", method = RequestMethod.GET)
    public BookTo editBook(@RequestParam("id") Long id, @RequestParam("title") String title, @RequestParam("authors") String author) {
    	BookTo book = bookService.findBookById(id);
    	book.setTitle(title);
    	book.setAuthors(author);
    	return bookService.saveBook(book);
    }
    
}
