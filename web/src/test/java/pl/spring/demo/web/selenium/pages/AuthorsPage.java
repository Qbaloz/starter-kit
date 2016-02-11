package pl.spring.demo.web.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class AuthorsPage extends AbstractPageObject {

	@FindBy(css="input[name='searchByPrefix'][ng-model='query']")
	private WebElement searchInput;
	
	@FindBy(css="[ng-repeat='author in authors | filter:query']")
	private List<WebElement> authorsList;
	
	public AuthorsPage(WebDriver driver) {
		super(driver);
	}
	
	public AuthorsPage setPrefix(String prefix) {
		this.searchInput.sendKeys(prefix);
		return this;
	}
	
	public List<WebElement> getAuthorsList(){
		return authorsList;
	}

}
