package pl.spring.demo.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.BookTo;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() {
        cacheManager.getCache("booksCache").clear();
    }

    @Test
    public void testShouldFindAllBooks() {
        // when
        List<BookTo> allBooks = bookService.findAllBooks();
        // then
        assertNotNull(allBooks);
        assertFalse(allBooks.isEmpty());
        assertEquals(8, allBooks.size());
    }

    @Test
    @Ignore
    public void testShouldFindAllBooksByTitle() {
        // given
        final String title = "Opium w rosole";
        // when
        List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
        // then
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
    }

    @Test(expected = BookNotNullIdException.class)
    public void testShouldThrowBookNotNullIdException() {
        // given
        final BookTo bookToSave = new BookTo();
        bookToSave.setId(22L);
        // when
        bookService.saveBook(bookToSave);
        // then
        fail("test should throw BookNotNullIdException");
    }
    
    @Test
    public void testShouldSetIdAutomatically(){
    	// given
    	final BookTo bookToSave = new BookTo();
    	bookToSave.setId(null);
    	//when
    	BookTo bookAfterSave = bookService.saveBook(bookToSave);
    	//then
    	Long longObject = new Long(7L);
    	assertEquals(longObject,bookAfterSave.getId());
    }
    
    @Test
    public void testShouldSetSecondBookIdAutomatically(){
    	// given
    	final BookTo bookToSave = new BookTo();
    	bookToSave.setId(null);
    	//when
    	BookTo bookAfterSave = bookService.saveBook(bookToSave);
    	//then
    	Long longObject = new Long(8L);
    	assertEquals(longObject,bookAfterSave.getId());
    }
}
