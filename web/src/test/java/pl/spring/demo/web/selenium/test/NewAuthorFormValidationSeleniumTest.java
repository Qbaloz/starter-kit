package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.NewAuthorPage;
import pl.spring.demo.web.selenium.pages.NewBookPage;

public class NewAuthorFormValidationSeleniumTest extends AbstractSelenium {
	
	private NewBookPage newBookPage;
	private NewAuthorPage newAuthorPage;
	
	@Before
	public void setUp() {
		super.setUp();
		newBookPage = openBookService().clickBooks().clickAddBook();
	}

	@Test
	public void shouldCheckIfNewAuthorLastNameIsRequired() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newAuthorPage = newBookPage.clickAddAuthor();
		newAuthorPage.setFirstName("firstName");
		// then
		assertFalse(newAuthorPage.getAddAuthorButton().isEnabled());
	}
	
	@Test
	public void shouldCheckIfNewAuthorFirstNameIsRequired() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newAuthorPage = newBookPage.clickAddAuthor();
		newAuthorPage.setLastName("lastName");
		// then
		assertFalse(newAuthorPage.getAddAuthorButton().isEnabled());
	}

}
