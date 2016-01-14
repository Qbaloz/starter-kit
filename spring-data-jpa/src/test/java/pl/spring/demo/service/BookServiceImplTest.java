package pl.spring.demo.service;

import org.junit.Before;
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
    public void testShouldFindAllBooksByTitle() {
        // given
        final String title = "Opium w rosole";
        // when
        List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
        // then
        BookTo result = new BookTo(2L, "Opium w rosole", "Hanna Ożogowska");
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
        assertTrue(booksByTitle.size() == 1);
        assertEquals(result.getTitle(), booksByTitle.get(0).getTitle());
    }
    
    @Test
    public void testShouldFindAllBooksByTitleUsingPrefixOnly() {
        // given
    	final String title = "Przygody Odys";
        // when
        List<BookTo> booksByTitle = bookService.findBooksByTitle(title);
        // then
        BookTo result = new BookTo(3L, "Przygody Odyseusza", "Jan Parandowski");
        assertNotNull(booksByTitle);
        assertFalse(booksByTitle.isEmpty());
        assertTrue(booksByTitle.size() == 1);
        assertEquals(result.getTitle(), booksByTitle.get(0).getTitle());
    }

    @Test
    public void testShouldFindAllBooksByAuthor() {
        // given
        final String author = "Hanna Ożogowska";
        // when
        List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
        // then
        BookTo result = new BookTo(2L, "Opium w rosole", "Hanna Ożogowska");
        assertNotNull(booksByAuthor);
        assertFalse(booksByAuthor.isEmpty());
        assertTrue(booksByAuthor.size() == 1);
        assertEquals(result.getAuthors(), booksByAuthor.get(0).getAuthors());
    }
    
    @Test
    public void testShouldFindAllBooksByAuthorPrefix() {
        // given
        final String author = "Hanna Ożo";
        // when
        List<BookTo> booksByAuthor = bookService.findBooksByAuthor(author);
        // then
        BookTo result = new BookTo(2L, "Opium w rosole", "Hanna Ożogowska");
        assertNotNull(booksByAuthor);
        assertFalse(booksByAuthor.isEmpty());
        assertTrue(booksByAuthor.size() == 1);
        assertEquals(result.getAuthors(), booksByAuthor.get(0).getAuthors());
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
