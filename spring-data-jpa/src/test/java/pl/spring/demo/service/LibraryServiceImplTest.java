package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class LibraryServiceImplTest {

	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private BookService bookService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShouldFindAllLibraries() {
        // when
        List<LibraryEntity> allLibraries = libraryService.findAllLibraries();
        // then
        assertNotNull(allLibraries);
        assertFalse(allLibraries.isEmpty());
        assertEquals(2, allLibraries.size());
	}
	
	@Test
	public void testShouldDeleteLibraryAndAllBooksInLibrary(){
		// given
		long libraryId = 2L;
        // when
		libraryService.deleteLibrary(libraryId);
		List<BookTo> allBooks = bookService.findAllBooks();
        // then
        assertNotNull(allBooks);
        assertFalse(allBooks.isEmpty());
        assertEquals(2, allBooks.size());
	}

}
