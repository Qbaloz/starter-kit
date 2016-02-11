package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.HomePage;

public class HomePageSeleniumTest extends AbstractSelenium {

	private HomePage homePage;
	
	@Before
	public void setUp() {
		super.setUp();
		homePage = openBookService();
	}

	@Test
	public void testShouldOpenBooksPage() {
		//given
		homePage.clickBooks();
		//when
		boolean isElementOnPage = homePage.hasElement("[ng-click='addBook()']");
		//then
		assertTrue(isElementOnPage);
	}
	
	@Test
	public void testShouldOpenAuthorsPage() {
		//given
		homePage.clickAuthors();
		// when
		boolean isElementOnPage = homePage.hasElement("input[name='searchByPrefix'][ng-model='query']");
		//then
		assertTrue(isElementOnPage);
	}

}
