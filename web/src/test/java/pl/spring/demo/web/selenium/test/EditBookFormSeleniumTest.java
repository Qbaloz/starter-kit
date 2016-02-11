package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.EditBookPage;

public class EditBookFormSeleniumTest extends AbstractSelenium {

	private EditBookPage editBookPage;
	
	@Before
	public void setUp() {
		super.setUp();
		editBookPage = openBookService().clickBooks().clickSearchBooks().clickEditBook();
	}

	@Test
	public void testShouldCheckIfTitleIsRequired() {
		//given
		editBookPage.getTitleInput().clear();
		//when
		editBookPage.clickEditBook();
		//then
		assertFalse(editBookPage.getEditBookButton().isEnabled());
	}
	
	@Test
	public void testShouldCheckIfEditBookIsPossible() {
		//given
		editBookPage.getTitleInput().clear();
		editBookPage.setTitle("123");
		//when
		editBookPage.clickEditBook();
		//then
		assertTrue(editBookPage.getEditBookButton().isEnabled());
	}

}
