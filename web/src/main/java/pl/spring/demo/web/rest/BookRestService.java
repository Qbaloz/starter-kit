package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BookRestService {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @ResponseBody
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }
    
    @ResponseBody
    @RequestMapping(value = "/books/edit", method = RequestMethod.POST)
    public BookTo editBook(@RequestBody BookTo book) {
    	BookTo bookTo = bookService.findBookById(book.getId());
    	bookTo.setTitle(book.getTitle());
    	bookTo.setAuthors(book.getAuthors());
    	return bookService.saveBook(bookTo);
    }
    
    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.POST)
    public String deleteBook(Map<String, Object> params, @PathVariable Long id) {
    	BookTo book = bookService.findBookById(id);
    	params.put("book", book);
    	bookService.deleteBook(id);
    	return "delete";
    }
    
}
