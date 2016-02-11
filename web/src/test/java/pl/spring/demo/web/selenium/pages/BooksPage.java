package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.spring.demo.web.selenium.AbstractPageObject;

public class BooksPage extends AbstractPageObject {

	@FindBy(css="[ng-click='addBook()']")
	private WebElement addBook;
	@FindBy(css="[ng-click='editBook(book)']")
	private WebElement editBook;
	@FindBy(css="[ng-click='search()']")
	private WebElement searchBooks;
	
	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	public NewBookPage clickAddBook() {
		addBook.click();
		return PageFactory.initElements(driver, NewBookPage.class);
	}
	
	public EditBookPage clickEditBook() {
		editBook.click();
		return PageFactory.initElements(driver, EditBookPage.class);
	}
	
	public BooksPage clickSearchBooks() {
		searchBooks.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}
	
}
