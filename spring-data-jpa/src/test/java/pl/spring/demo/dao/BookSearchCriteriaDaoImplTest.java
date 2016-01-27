package pl.spring.demo.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.service.impl.BookSearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class BookSearchCriteriaDaoImplTest {

	@Autowired
	private BookSearchCriteriaDao bookSearchCriteriaDao;

	@Test
	public void testShouldFindBookAllBooksWithNullValues() {
        // given
		BookSearchCriteria book = new BookSearchCriteria(null, null, null);
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals(3, booksEntity.size());
	}
	
	@Test
	public void testShouldFindBookOnlyByTitle() {
        // given
		BookSearchCriteria book = new BookSearchCriteria("Pierwsza książka", null, null);
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookOnlyByAuthor() {
        // given
		BookSearchCriteria book = new BookSearchCriteria(null, "Jan Kowalski", null);
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookOnlyByLibraryName() {
        // given
		BookSearchCriteria book = new BookSearchCriteria(null, null, "Biblioteka Miejska");
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByTitleAndAuthor() {
        // given
		BookSearchCriteria book = new BookSearchCriteria("Pierwsza książka", "Jan Kowalski", null);
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByTitleAndLibraryName() {
        // given
		BookSearchCriteria book = new BookSearchCriteria("Trzecia książka", null, "Biblioteka Wojewódzka");
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Trzecia książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByAuthorAndLibraryName() {
        // given
		BookSearchCriteria book = new BookSearchCriteria(null, "Jan Kowalski", "Biblioteka Wojewódzka");
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Trzecia książka", booksEntity.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByAllParameters() {
        // given
		BookSearchCriteria book = new BookSearchCriteria("Trzecia książka", "Jan Kowalski", "Biblioteka Wojewódzka");
        // when
        List<BookEntity> booksEntity = bookSearchCriteriaDao.findBook(book);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Trzecia książka", booksEntity.get(0).getTitle());
	}
	
	

}
