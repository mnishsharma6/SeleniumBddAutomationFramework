package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.MyAccountsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyAccountsSteps {
	
	private MyAccountsPage myAccountsPage;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("User has logged in to the Application")
	public void user_has_logged_in_to_the_application(DataTable loginCred) {
		List<Map<String, String>> loginCredMap = loginCred.asMaps();
		String username = loginCredMap.get(0).get("Username");
		String password = loginCredMap.get(0).get("Password");
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		myAccountsPage = loginPage.login(username, password);
	}
	
	@Given("User is on Account Page")
	public void user_is_on_account_page() {
		boolean isLogoutButtonVisible = myAccountsPage.userIsOnAccountPage();
		Assert.assertTrue(isLogoutButtonVisible);
	}
	
	@Then("Account Page title should be {string}")
	public void account_page_title_should_be(String expectedTitle) {
		String actualTitle = myAccountsPage.accountsPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Then("I should see following contents for My Account section")
	public void account_page_title_should_be(DataTable expectedMyAccountContents) {
		List<String> exList = expectedMyAccountContents.asList();
		List<String> acList = myAccountsPage.getMyAccountSectionContentsList();
		System.out.println(exList);
		System.out.println(acList);
		Assert.assertEquals(exList, acList);

	}



}