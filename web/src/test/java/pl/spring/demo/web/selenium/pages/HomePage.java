package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.spring.demo.web.selenium.AbstractPageObject;

public class HomePage extends AbstractPageObject{
	
	@FindBy(css="[href='#/books/book-list']")
	private WebElement books;
	
	@FindBy(css="[href='#/authors/author-list']")
	private WebElement authors;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9000/#/main/welcome");
	}
	
	public BooksPage clickBooks() {
		books.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}
	
	public AuthorsPage clickAuthors() {
		authors.click();
		return PageFactory.initElements(driver, AuthorsPage.class);
	}
	
}
