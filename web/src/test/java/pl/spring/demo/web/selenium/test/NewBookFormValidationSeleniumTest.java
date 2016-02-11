package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.NewBookPage;

public class NewBookFormValidationSeleniumTest extends AbstractSelenium {

	private NewBookPage newBookPage;
	@Before
	public void setUp() {
		super.setUp();
		newBookPage = openBookService().clickBooks().clickAddBook();
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		// given
		newBookPage.setFirstName("firstName");
		newBookPage.setLastName("lastName");
		// when
		newBookPage.clickSaveBook();
		// then
		assertFalse(newBookPage.getSaveBookButton().isEnabled());
	}
	
	@Test
	public void shouldCheckIfFirstNameIsRequired() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setLastName("lastName");
		// when
		newBookPage.clickSaveBook();
		// then
		assertFalse(newBookPage.getSaveBookButton().isEnabled());
	}
	
	@Test
	public void shouldCheckIfLastNameIsRequired() {
		// given
		newBookPage.setTitle("title");
		newBookPage.setFirstName("firstName");
		// when
		newBookPage.clickSaveBook();
		// then
		assertFalse(newBookPage.getSaveBookButton().isEnabled());
	}

}
