package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.spring.demo.web.selenium.AbstractPageObject;

public class EditBookPage extends AbstractPageObject {

	@FindBy(css="[ng-click='saveBook()']")
	private WebElement editBook;
	@FindBy(css="input[ng-model='book.title']")
	private WebElement title;
	
	public EditBookPage(WebDriver driver) {
		super(driver);
	}
	
	public NewBookPage clickEditBook() {
		editBook.click();
		return PageFactory.initElements(driver, NewBookPage.class);
	}
	
	public EditBookPage setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public WebElement getEditBookButton() {
		return editBook;
	}
	
	public WebElement getTitleInput(){
		return title;
	}
	
}