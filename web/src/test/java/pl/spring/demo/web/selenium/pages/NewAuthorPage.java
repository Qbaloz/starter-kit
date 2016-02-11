package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class NewAuthorPage extends AbstractPageObject{

	@FindBy(css="[ng-model='author.firstName'][required='']")
	private WebElement firstName;
	
	@FindBy(css="[ng-model='author.lastName'][required='']")
	private WebElement lastName;
	
	@FindBy(css="[ng-click='addAuthor()'][name='addNewAuthor']")
	private WebElement addAuthorButton;
	
	public NewAuthorPage(WebDriver driver) {
		super(driver);
	}

	public NewAuthorPage setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public NewAuthorPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}
	
	public NewBookPage clickAddNewAuthor() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, NewBookPage.class);
	}
	
	public WebElement getAddAuthorButton(){
		return addAuthorButton;
	}
	
}
