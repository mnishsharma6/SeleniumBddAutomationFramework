package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountsPage {

	private WebDriver driver;
	
	// constructor
	public MyAccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Locators
	private By myAccoutSectionList = By.xpath("//h2[text()='My Account']/following-sibling::ul[@class='list-unstyled'][1]/li");
	private By logoutElement = By.xpath("//div[@class='list-group']/a[13]");
	
	// public methods
	public boolean userIsOnAccountPage() {
		boolean isLogoutButtonVisible = driver.findElement(logoutElement).isDisplayed();
		return isLogoutButtonVisible;
	}
	
	public String accountsPageTitle() {
		String accountsPageTitle = driver.getTitle();
		return accountsPageTitle;
	}
	
	public List<String> getMyAccountSectionContentsList() {
		List<WebElement> webelementContentList = driver.findElements(myAccoutSectionList);
		List<String> contentsList = new ArrayList<>();
		for (WebElement listobject : webelementContentList) {
			contentsList.add(listobject.getText());
		}
		return contentsList;
		
		
	}

}
