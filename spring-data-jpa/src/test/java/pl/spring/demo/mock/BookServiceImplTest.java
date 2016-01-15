package pl.spring.demo.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookDao bookDao;
    @Mock
    private BookMapper mapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldSaveBook() {
        // given
    	BookEntity bookEntity = new BookEntity(1L, "title", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "firstName", "lastName"))));
        BookTo book = new BookTo(1L, "title", "firstName lastName");
        BookTo bookToAfterMapFromBookEntity = new BookTo(1L, "title", "firstName lastName");
        Mockito.when(bookDao.save(bookEntity)).thenReturn(bookEntity);
        Mockito.when(mapper.bookTo2BookEntity(book)).thenReturn(bookEntity);
        Mockito.when(mapper.bookEntity2BookTo(bookEntity)).thenReturn(bookToAfterMapFromBookEntity);
        // when
        BookTo result = new BookTo();
        result = bookService.saveBook(book);
        // then
        Mockito.verify(bookDao).save(bookEntity);
        assertEquals(1L, result.getId().longValue());
    }
    
    @Test
    public void testShouldSaveBookAndCheckAuthors() {
        // given
    	BookEntity bookEntity = new BookEntity(1L, "title", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "firstName", "lastName"))));
        BookTo book = new BookTo(1L, "title", "firstName lastName");
        BookTo bookToAfterMapFromBookEntity = new BookTo(1L, "title", "firstName lastName");
        Mockito.when(bookDao.save(bookEntity)).thenReturn(bookEntity);
        Mockito.when(mapper.bookTo2BookEntity(book)).thenReturn(bookEntity);
        Mockito.when(mapper.bookEntity2BookTo(bookEntity)).thenReturn(bookToAfterMapFromBookEntity);
        // when
        BookTo result = new BookTo();
        result = bookService.saveBook(book);
        // then
        Mockito.verify(bookDao).save(bookEntity);
        assertEquals(bookToAfterMapFromBookEntity.getAuthors(), result.getAuthors());
    }
    
    @Test
    public void testShouldSaveBookAndCheckTitle() {
        // given
    	BookEntity bookEntity = new BookEntity(1L, "title", new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1L, "firstName", "lastName"))));
        BookTo book = new BookTo(1L, "title", "firstName lastName");
        BookTo bookToAfterMapFromBookEntity = new BookTo(1L, "title", "firstName lastName");
        Mockito.when(bookDao.save(bookEntity)).thenReturn(bookEntity);
        Mockito.when(mapper.bookTo2BookEntity(book)).thenReturn(bookEntity);
        Mockito.when(mapper.bookEntity2BookTo(bookEntity)).thenReturn(bookToAfterMapFromBookEntity);
        // when
        BookTo result = new BookTo();
        result = bookService.saveBook(book);
        // then
        Mockito.verify(bookDao).save(bookEntity);
        assertEquals(bookToAfterMapFromBookEntity.getTitle(), result.getTitle());
    }
}
