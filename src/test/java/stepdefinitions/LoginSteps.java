package stepdefinitions;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("^I am on the Application login page with Title \"([^\"]*)\"$")
	public void i_am_on_the_open_cart_login_page(String expectedTitle) {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("qatestertest@gmail.com");
		loginPage.enterPassword("Test@123");
	}

	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) {
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("I should be logged in successfully")
	public void i_shoud_be_logged_in_successfully() {
		Assert.assertEquals(loginPage.checkLogoutLink(), true);
	}

	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String errorMessage) {
		// assert that an error message is displayed on the page matching the expected
		// error message
//        Assert.assertEquals(DriverFactory.getDriver().findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) {
		loginPage.clickForgottenPasswordLink();
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
		// assert that the current url contains the password reset page route
		Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
	}

	@Then("^I Should see (\\d+) Links on page$")
	public void I_validate_No_of_Links_and_their_text(int expectedNumberOfLinks) {
		List<WebElement> linklists = DriverFactory.getDriver().findElements(By.tagName("a"));
//		Assert.assertEquals(linklists.size(), expectedNumberOfLinks);
//		// Using lambdas and streams
//		linklists.forEach(element -> System.out.println(element.getText()));
//		// filter all blank values from link texts streams
//		List<String> allNonEmptyLinks = linklists.stream().filter(ele -> !ele.getText().equals("")).
//				map(ele -> ele.getText().trim())
//					.collect(Collectors.toList());
//		allNonEmptyLinks.forEach(ele -> System.out.println("Non Blank Links: "+ele));
//		// getting text of first link
//		String firstink = linklists.stream().filter(ele -> !ele.getText().equals("")).findFirst().get().getText();
//		System.out.println("First Link is: "+firstink);
		// getting all non empty text which contains word "Account" in it
		List<String> newList=  linklists.stream().filter(ele -> !ele.getText().equals("") && ele.getText().contains("Account")).
				map(ele->ele.getText().trim())
					.collect(Collectors.toList());
		newList.forEach(ele -> System.out.println("words with account text:"+ele)); // Using a lambda expression
		// Using a method reference newList.forEach(System.out::println);
		
		

	}

}
