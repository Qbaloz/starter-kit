package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.NewAuthorPage;
import pl.spring.demo.web.selenium.pages.NewBookPage;

public class NewBookFormAddingBooksSeleniumTest extends AbstractSelenium {

	private NewBookPage newBookPage;
	private NewAuthorPage newAuthorPage;
	
	@Before
	public void setUp() {
		super.setUp();
		newBookPage = openBookService().clickBooks().clickAddBook();
	}
	
	@Test
	public void shouldCheckIfAddingNewBookWithTwoAuthorsIsPossible() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newAuthorPage = newBookPage.clickAddAuthor();
		newAuthorPage.setFirstName("firstName");
		newAuthorPage.setLastName("lastName");
		newAuthorPage.clickAddNewAuthor();
		// then
		assertTrue(newBookPage.getSaveBookButton().isEnabled());
	}
	
	@Test
	public void shouldAddNewBook() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newBookPage.clickSaveBook();
		// then
		assertTrue(newBookPage.getSaveBookButton().isEnabled());
	}
	
	@Test
	public void shouldAddNewBookWithTwoAuthors() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newAuthorPage = newBookPage.clickAddAuthor();
		newAuthorPage.setFirstName("firstName");
		newAuthorPage.setLastName("lastName");
		newAuthorPage.clickAddNewAuthor();
		// then
		assertTrue(newBookPage.getSaveBookButton().isEnabled());
	}

}
