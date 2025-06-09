package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage lp;

    public LoginPageTest() {
        this.driver = DriverFactory.getDriver();  // get driver from DriverFactory singleton/static method
        this.lp = new LoginPage(driver);
    }

    @Given("the user navigates to application URL")
    public void user_navigates_to_url() {
        System.out.println("User is on login page");
    }

    @When("the user enters a valid username and valid password")
    public void user_enters_valid_credentials() {
        lp.enterUsername("admintwo");
        lp.enterPassword("Admintwo@123");
    }

    @And("the user clicks the Login button")
    public void user_clicks_login_button() {
        lp.clickLogin();
    }

    @Then("the user should be successfully logged in")
    public void user_should_be_logged_in() {
        System.out.println("User successfully logged in.");
    }
}
