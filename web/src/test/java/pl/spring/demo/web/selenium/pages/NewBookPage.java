package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.spring.demo.web.selenium.AbstractPageObject;

public class NewBookPage extends AbstractPageObject{
	
	@FindBy(css="[ng-model='book.title']")
	private WebElement title;
	
	@FindBy(css="[ng-model='book.authors[0].firstName']")
	private WebElement firstName;
	
	@FindBy(css="[ng-model='book.authors[0].lastName']")
	private WebElement lastName;
	
	@FindBy(css="[ng-click='saveBook()']")
	private WebElement saveBookButton;
	
	@FindBy(css="[ng-click='addAuthor()']")
	private WebElement addAuthorButton;

	public NewBookPage(WebDriver driver) {
		super(driver);
	}

	public NewBookPage setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public NewBookPage setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public NewBookPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public HomePage clickSaveBook() {
		saveBookButton.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public NewAuthorPage clickAddAuthor() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, NewAuthorPage.class);
	}
	
	public WebElement getSaveBookButton(){
		return addAuthorButton;
	}
	
	public WebElement getAddAuthorButton(){
		return saveBookButton;
	}
	
}
