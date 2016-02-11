package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.AuthorsPage;

public class AuthorsPageSearchAuthorByPrefix extends AbstractSelenium {

	private AuthorsPage authorsPage;
	
	@Before
	public void setUp() {
		super.setUp();
		authorsPage = openBookService().clickAuthors();
	}

	@Test
	public void testShouldReturnAuthorByPrefix() {
		//given
		authorsPage.setPrefix("Jan");
		//when
		List<WebElement> authorsList = authorsPage.getAuthorsList();
		//then
		assertTrue(authorsList.get(0).getText().equals("Jan Kowalski"));
	}
	
	@Test
	public void testShouldReturnAuthorThatNotExistByPrefix() {
		//given
		authorsPage.setPrefix("Janek");
		// when
		List<WebElement> authorsList = authorsPage.getAuthorsList();
		//then
		assertTrue(authorsList.isEmpty());
	}

}
