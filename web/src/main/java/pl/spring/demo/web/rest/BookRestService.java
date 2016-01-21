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

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public BookTo editBook(@RequestBody BookTo book) {
    	return bookService.updateBook(book);
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.DELETE)
    public BookTo deleteBook(Map<String, Object> params, @RequestParam Long id) {
    	return bookService.deleteBook(id);
    }
    
    @RequestMapping(value = "/books/add_new", method = RequestMethod.POST)
    public BookTo saveBookTwo(HttpServletRequest request) {
    	
    	BookTo book = new BookTo();
    	book.setId(null);
    	book.setTitle(request.getParameter("title"));
    	book.setAuthors(request.getParameter("authors"));
    	
        return bookService.saveBook(book);
    }
    
}
