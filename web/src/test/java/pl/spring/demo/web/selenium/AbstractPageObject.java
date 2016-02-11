package pl.spring.demo.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AbstractPageObject {
	protected WebDriver driver;
	
	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean hasError() {
		try {
			driver.findElement(By.className("ng-invalid"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	
	public boolean hasElement(String selector) {
		try {
			driver.findElement(By.cssSelector(selector));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
