package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By emailInputLocator = By.name("email");
	private By passwordInputLocator = By.name("password");
	private By loginButtonLocator = By.xpath("//input[@type='submit']");
	private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
	private By logoutLinkLocator = By.linkText("Logout");

	// methods page actions

    /*
     * According to page object model, If a method is landing you to the next page, 
     * then its method responsibility to give you the object of that landing page (Page Chaining)
     */
	public MyAccountsPage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();
		return new MyAccountsPage(driver);
	}
	
	public void enterEmail(String email) {
		WebElement emailInput = driver.findElement(emailInputLocator);
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement emailInput = driver.findElement(passwordInputLocator);
		emailInput.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
	}

	public void clickForgottenPasswordLink() {
		WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
		forgottenPasswordLink.click();
	}

	public boolean checkForgotPwdLink() {
		return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
	}

	public boolean checkLogoutLink() {
		return driver.findElement(logoutLinkLocator).isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getForgotPwdPageUrl() {
		String forgotPwdPageUrl = driver.getCurrentUrl();
		return forgotPwdPageUrl;
	}
}
